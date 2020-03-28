package harmonicvalidator.tests;

import harmonicvalidator.parser.nodes.Note;
import harmonicvalidator.utils.VoiceType;
import java.util.HashMap;

public class VoiceRange {
    public static boolean validateRule(Note note)
    {
        HashMap<VoiceType, int[]> voiceRanges = new HashMap<>();
        voiceRanges.put(VoiceType.BASS, new int[]{13, 24});
        voiceRanges.put(VoiceType.TENOR, new int[]{16, 28});
        voiceRanges.put(VoiceType.SOPRANO, new int[]{20, 31});
        voiceRanges.put(VoiceType.ALTO, new int[]{23, 35});

        return(note.getId() >= voiceRanges.get(note.getVoiceType())[0] && note.getId() <= voiceRanges.get(note.getVoiceType())[1]);
    }
}
