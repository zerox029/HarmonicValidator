package harmonicvalidator.tests;

import harmonicvalidator.parser.*;
import harmonicvalidator.parser.nodes.*;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

public class TestSuite {
    public static boolean runSuite(String file) throws ParserConfigurationException, IOException, SAXException
    {
        MusicXMLParser parser = new MusicXMLParser();
        List<Measure> measures = parser.parse(file);

        applyNoteModifications(measures);

        return singleNoteTests(NoteOrdering.bottomUp(measures));
    }

    private static void applyNoteModifications(List<Measure> measures)
    {
        for(int i = 0; i < measures.size(); i++)
        {
            NoteModifiers.AssignVoiceTypes(measures.get(i));
        }
    }

    private static boolean singleNoteTests(List<Note> notes)
    {
        boolean result = true;
        for(Note note : notes)
        {
            result = VoiceRange.validateRule(note);
        }

        return result;
    }
}
