import XMLTest.Person;
import XMLTest.PersonManager;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Test
{
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException, SAXException
    {
        System.out.println(Arrays.toString(PersonManager.loadPersons()));
    }
}
