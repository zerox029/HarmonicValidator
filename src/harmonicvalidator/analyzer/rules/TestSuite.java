package harmonicvalidator.analyzer.rules;

import harmonicvalidator.parser.nodes.Note;

public class TestSuite {
    public static boolean runSuite(Note note)
    {
        return VoiceRange.validateRule(note);
    }
}
