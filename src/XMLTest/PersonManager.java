package XMLTest;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PersonManager
{

    public static void savePersons(Person[] persons) throws ParserConfigurationException, TransformerException, FileNotFoundException
    {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dom = db.newDocument();

        Element root = dom.createElement("xml");
        Element e;

        for(int i = 0; i < persons.length; i++)
        {
            e = dom.createElement("name");
            e.appendChild(dom.createTextNode(persons[i].name));
            root.appendChild(e);

            e = dom.createElement("lastName");
            e.appendChild(dom.createTextNode(persons[i].lastName));
            root.appendChild(e);

            e = dom.createElement("age");
            e.appendChild(dom.createTextNode(Integer.toString(persons[i].age)));
            root.appendChild(e);
        }

        dom.appendChild(root);

        Transformer t = TransformerFactory.newDefaultInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        t.transform(new DOMSource(dom), new StreamResult(new FileOutputStream("./saves.xml")));
    }

    public static Person[] loadPersons() throws ParserConfigurationException, IOException, SAXException
    {
        DocumentBuilder loader = DocumentBuilderFactory.newDefaultInstance().newDocumentBuilder();
        Document dom = loader.parse(new FileInputStream("./saves.xml"));

        Person[] result = new Person[dom.getElementsByTagName("name").getLength()];

        String name = "", lastName = "";
        int age = -1;

        for(int i = 0; i < result.length; i++)
        {
            name = dom.getElementsByTagName("name").item(i).getTextContent();
            lastName = dom.getElementsByTagName("lastName").item(i).getTextContent();
            age = Integer.parseInt(dom.getElementsByTagName("age").item(i).getTextContent());

            result[i] = new Person(name, lastName, age);
        }

        return result;
    }
}
