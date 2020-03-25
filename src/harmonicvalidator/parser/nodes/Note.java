package harmonicvalidator.parser.nodes;

import harmonicvalidator.utils.NoteToId;
import harmonicvalidator.utils.VoiceType;

import java.util.HashMap;

public class Note {
    public String name;
    int octave;
    int duration;
    int id;
    VoiceType voiceType;

    public Note(String name, int octave, int duration) {
        this.name = name;
        this.octave = octave;
        this.duration = duration;
        setId();
    }

    public String getName() { return name; }
    public int getOctave() { return octave; }
    public double getDuration() { return duration; }
    public int getId() { return id; }
    public VoiceType getVoiceType() { return voiceType; }

    public void setVoiceType(VoiceType voice)
    {
        this.voiceType = voice;
    }

    private void setId()
    {
        //ugly
        if(octave == 0)
        {
            if(name == "A")
                id = 0;
            else if(name == "B")
                id = 1;
        }
        else
        {
            id = NoteToId.map.get(name) + (7 * (octave - 1)) + 1;
        }
    }
}
