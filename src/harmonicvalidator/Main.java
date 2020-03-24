package harmonicvalidator;

import harmonicvalidator.parser.MusicXMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        MusicXMLParser parser = new MusicXMLParser();
        parser.parse("C:/Development/Java/HarmonicValidator/MusicXML_Doc/MusicXMLTest.musicxml");
    }
}
