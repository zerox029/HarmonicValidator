package harmonicvalidator.parser.nodes;

public class Note {
    public String name;
    int octave;
    double duration;

    public Note(String name, int octave, double duration) {
        this.name = name;
        this.octave = octave;
        this.duration = duration;
    }

    public String getName() { return name; }
    public int getOctave() { return octave; }
    public double getDuration() { return duration; }
}
