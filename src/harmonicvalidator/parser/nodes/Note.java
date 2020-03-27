package harmonicvalidator.parser.nodes;

import harmonicvalidator.utils.NoteToId;
import harmonicvalidator.utils.VoiceType;

import java.util.HashMap;

public class Note {
    public String name;
    int octave;
    int duration;
    int pitchId;
    int staff;
    boolean isChord;
    VoiceType voiceType;

    public Note(String name, int octave, int duration, boolean chord) {
        this.name = name;
        this.octave = octave;
        this.duration = duration;
        this.isChord = chord;
        setId();
    }

    public String getName() { return name; }
    public int getOctave() { return octave; }
    public double getDuration() { return duration; }
    public int getId() { return pitchId; }
    public VoiceType getVoiceType() { return voiceType; }
    public boolean isChord() { return isChord; }

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
                pitchId = 0;
            else if(name == "B")
                pitchId = 1;
        }
        else
        {
            pitchId = NoteToId.map.get(name) + (7 * (octave - 1)) + 1;
        }
    }
}
