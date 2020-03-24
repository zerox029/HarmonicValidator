package harmonicvalidator.parser.nodes;

import java.util.List;

public class Measure {
    int[] time;
    int key;
    List<Note> notes;

    public Measure(int[] time, int key, List<Note> notes)
    {
        this.time = time;
        this.key = key;
        this.notes = notes;
    }

    public int[] getTime() { return time; }
    public int getKey() { return key; }
    public List<Note> getNotes() { return notes; }
}
