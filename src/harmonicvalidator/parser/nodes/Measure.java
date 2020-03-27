package harmonicvalidator.parser.nodes;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Measure {
    int[] time;
    int key;
    int staff;
    List<Note>[] notes;

    //Need an array of lists to represent multiple staves
    public Measure(int[] time, int key, List<Note>[] notes)
    {
        this.time = time;
        this.key = key;
        this.notes = notes;
    }

    public int[] getTime() { return time; }
    public int getKey() { return key; }
    public List<Note>[] getNotes() { return notes; }
}
