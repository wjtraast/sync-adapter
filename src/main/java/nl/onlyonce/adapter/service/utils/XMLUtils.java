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

        String cleanXml = xml.replace("\n","").replace("\r","").replace("\t","");
        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(cleanXml));
            Document doc = builder.parse(src);
            return doc;
        } catch (Exception ex) {
            return null;

        }
    }
}
