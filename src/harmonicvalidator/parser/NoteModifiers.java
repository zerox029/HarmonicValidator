package harmonicvalidator.parser;

import harmonicvalidator.parser.nodes.*;
import harmonicvalidator.utils.VoiceType;
import java.util.List;

public class NoteModifiers {
    public static void AssignVoiceTypes(List<Measure> measures)
    {
        int counter = 0;
        for(Note note : NoteOrdering.bottomUp(measures))
        {
            if(counter >= 4)
                counter = 0;

            switch (counter)
            {
                case 0:
                    note.setVoiceType(VoiceType.BASS);
                    break;
                case 1:
                    note.setVoiceType(VoiceType.TENOR);
                    break;
                case 2:
                    note.setVoiceType(VoiceType.ALTO);
                    break;
                case 3:
                    note.setVoiceType(VoiceType.SOPRANO);
                    break;
            }

            counter++;
        }
    }
}
