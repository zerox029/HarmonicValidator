package harmonicvalidator;

import harmonicvalidator.tests.TestSuite;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException
    {
        TestSuite.runSuite("C:/Development/Java/HarmonicValidator/MusicXMLTest.musicxml");
    }
}
