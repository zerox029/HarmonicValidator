package harmonicvalidator;

import harmonicvalidator.analyzer.Validator;
import harmonicvalidator.parser.MusicXMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        Validator val = new Validator();
        val.validate("C:/Development/Java/HarmonicValidator/MusicXMLTest.musicxml");
    }
}
