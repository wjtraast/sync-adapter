package nl.onlyonce.adapter.service.utils;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * @author: Gerben
 */
public class XMLUtils {

    public static Document parseXml(String xml) {

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(xml));
            Document doc = builder.parse(src);
            return doc;
        } catch (Exception ex) {
            return null;

        }
    }
}
