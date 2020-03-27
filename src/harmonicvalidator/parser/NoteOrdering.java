package harmonicvalidator.parser;

import harmonicvalidator.parser.nodes.*;
import java.util.ArrayList;
import java.util.List;

public class NoteOrdering {
    public static List<Note> bottomUp(Measure measure)
    {
        List<Note> notes = new ArrayList<>();

        //Add top staff notes
        int topStaffNoteCount = 0;
        for(Note note : measure.getNotes()[1])
        {
            notes.add(note);

            do
            {
                notes.add(measure.getNotes()[0].get(topStaffNoteCount));
                topStaffNoteCount++;
            } while (measure.getNotes()[0].size() > topStaffNoteCount && measure.getNotes()[0].get(topStaffNoteCount).isChord());
        }

        return notes;
    }
}
