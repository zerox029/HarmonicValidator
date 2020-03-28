package harmonicvalidator.parser;

import harmonicvalidator.parser.nodes.*;
import java.util.ArrayList;
import java.util.List;

public class NoteOrdering {
    public static List<Note> bottomUp(List<Measure> measures)
    {
        List<Note> notes = new ArrayList<>();

        for(int i = 0; i < measures.size(); i++)
        {
            Measure currentMeasureNotes = measures.get(i);

            //Add top staff notes
            int topStaffNoteCount = 0;
            for(Note note : currentMeasureNotes.getNotes()[1])
            {
                notes.add(note);

                do
                {
                    notes.add(currentMeasureNotes.getNotes()[0].get(topStaffNoteCount));
                    topStaffNoteCount++;
                } while (currentMeasureNotes.getNotes()[0].get(topStaffNoteCount).isChord());
            }
        }

        return notes;
    }
}
