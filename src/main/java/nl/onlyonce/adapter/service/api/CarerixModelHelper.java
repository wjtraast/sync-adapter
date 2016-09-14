package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;

/**
 * @author: Gerben
 */
public class CarerixModelHelper {


    public static String convertEmployee(CREmployee employee) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(employee.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            QName qName = new QName("com.carerix.api", "CREmployee");
            JAXBElement<CREmployee> root = new JAXBElement<>(qName, CREmployee.class, employee);

            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(root, sw);
            return stripNamespaces(sw.toString());


        } catch (Exception ex) {

        }
        return null;
    }

    private static String stripNamespaces(String data) {
        return data.replace("ns2:", "").replace(" xmlns:ns2=\"com.carerix.api\"", "");
    }

}
