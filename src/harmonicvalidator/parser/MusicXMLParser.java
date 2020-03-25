package harmonicvalidator.parser;

import harmonicvalidator.parser.nodes.Measure;
import harmonicvalidator.parser.nodes.Note;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MusicXMLParser {
    DocumentBuilderFactory factory;
    DocumentBuilder builder;

    public MusicXMLParser() throws ParserConfigurationException
    {
        factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    public List<Measure> parse(String file) throws IOException, SAXException
    {
        Document document = builder.parse(new File(file));
        document.getDocumentElement().normalize();

        List<Measure> measures = parseMeasures(document);

        return measures;
    }

    private List<Measure> parseMeasures(Document document)
    {
        NodeList measureNodes = document.getElementsByTagName("measure");
        List<Measure> measures = new ArrayList<>();

        for(int i = 0; i < measureNodes.getLength(); i++)
        {
            Element node = (Element) measureNodes.item(i);

            Element timeNode = (Element) node.getElementsByTagName("time").item(0);
            Element keyNode = (Element) node.getElementsByTagName("key").item(0);

            //Time
            int[] time = new int[2];
            if(timeNode != null)
            {
                time[0] = Integer.parseInt(timeNode.getElementsByTagName("beats").item(0).getTextContent());
                time[1] = Integer.parseInt(timeNode.getElementsByTagName("beat-type").item(0).getTextContent());
            }
            else
            {
                time = measures.get(i - 1).getTime();
            }

            //Key
            int key = 0;
            if(timeNode != null)
            {
                key = Integer.parseInt(keyNode.getElementsByTagName("fifths").item(0).getTextContent());
            }
            else
            {
                key = measures.get(i - 1).getKey();
            }

            List<Note> notes = parseNotes(node.getElementsByTagName("note"));


            measures.add(new Measure(time, key, notes));
        }

        return measures;
    }

    private List<Note> parseNotes(NodeList noteNodes)
    {
        List<Note> notes = new ArrayList<>();

        for(int i = 0; i < noteNodes.getLength(); i++)
        {
            Element node = (Element) noteNodes.item(i);
            Element pitchData = (Element) node.getElementsByTagName("pitch").item(0);

            String name = pitchData.getElementsByTagName("step").item(0).getTextContent();
            int octave = Integer.parseInt(pitchData.getElementsByTagName("octave").item(0).getTextContent());
            int duration = Integer.parseInt(node.getElementsByTagName("duration").item(0).getTextContent());

            notes.add(new Note(name, octave, duration));
        }

        return notes;
    }
}
