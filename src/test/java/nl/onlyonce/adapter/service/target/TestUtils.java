package nl.onlyonce.adapter.service.target;

import com.carerix.api.CREmployeeType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

/**
 * @author: Gerben
 */
public class TestUtils {

    public static String addFLElement(String data, String value) {
        return data  + value;
    }

    public static String convertEmployeeToString(CREmployeeType type) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(type.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            QName qName = new QName("com.carerix.api", "CREmployeeType");
            JAXBElement<CREmployeeType> root = new JAXBElement<CREmployeeType>(qName, CREmployeeType.class, type);


            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(root, sw);

            String data = sw.toString();
            data = data.replace("ns2:", "");
            data = data.replace(" xmlns:ns2=\"com.carerix.api\"", "");
            data = data.replace("CREmployeeType", "CREmployee");



            return data;

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static CREmployee convertStringToEmployee(String value) {
//        try {
//            JAXBContext jaxbContext = JAXBContext.newInstance(CREmployee.class);
//            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
//            StringReader reader = new StringReader(value);
//            return (CREmployee) unmarshaller.unmarshal(reader);
//
//
//
//        } catch (JAXBException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}
