package utils;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.UnmarshallerHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileInputStream;

public class XmlUtils {
    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        XMLReader xr = sp.getXMLReader();

        JAXBContext jc = JAXBContext.newInstance("utils");
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
        xr.setContentHandler(unmarshallerHandler);

        FileInputStream xmlStream = new FileInputStream("src/blog/log4j/sample1.xml");
        InputSource xmlSource = new InputSource(xmlStream);
        xr.parse(xmlSource);

        Log4JConfiguration config = (Log4JConfiguration) unmarshallerHandler.getResult();

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(config, System.out);
    }
}
