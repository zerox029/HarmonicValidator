package harmonicvalidator.analyzer;

import harmonicvalidator.analyzer.rules.TestSuite;
import harmonicvalidator.parser.MusicXMLParser;
import harmonicvalidator.parser.nodes.Measure;
import harmonicvalidator.parser.nodes.Note;
import harmonicvalidator.utils.VoiceType;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class Validator
{
    public void validate(String file) throws ParserConfigurationException, IOException, SAXException
    {
        MusicXMLParser parser = new MusicXMLParser();
        List<Measure> measures = parser.parse(file);

        for(int i = 0; i < measures.size(); i++)
        {
            AssignVoiceTypes(measures.get(i));

            for(Note note : measures.get(i).getNotes())
            {
                if(!TestSuite.runSuite(note))
                {
                    System.out.println("No good lulz. On note ");
                }
                else
                {
                    System.out.println("All good");
                }
            }

/*
            System.out.println("Bar " + (i + 1));
            System.out.println("Time: " + measures.get(i).getTime()[0] + "/" + measures.get(i).getTime()[1]);
            System.out.println("Key: " + measures.get(i).getKey());*/
        }

        //System.out.println(measures.get(0).getNotes().get(0).getId());
    }

    private void AssignVoiceTypes(Measure measure)
    {
        int counter = 0;
        for(Note note : measure.getNotes())
        {
            if(counter >= 4)
                counter = 0;

            switch (counter)
            {
                case 0:
                    note.setVoiceType(VoiceType.TENOR);
                    break;
                case 1:
                    note.setVoiceType(VoiceType.ALTO);
                    break;
                case 2:
                    note.setVoiceType(VoiceType.SOPRANO);
                    break;
                case 3:
                    note.setVoiceType(VoiceType.BASS);
                    break;
            }

            counter++;
        }
    }
}
