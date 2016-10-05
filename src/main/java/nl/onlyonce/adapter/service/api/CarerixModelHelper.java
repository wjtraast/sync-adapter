package nl.onlyonce.adapter.service.api;

import com.carerix.api.CREmployee;
import com.carerix.api.CRUser;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.carerix.CarerixModel;
import org.w3c.dom.Document;

import javax.xml.bind.*;
import javax.xml.namespace.QName;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author: Gerben
 */
@Log
public class CarerixModelHelper {


    public static CREmployee convertEmployee(String result) {

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(CREmployee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(result);
            return (CREmployee) unmarshaller.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

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
            log.info(ex.getMessage());
        }
        return null;
    }

    private static String stripNamespaces(String data) {
        return data.replace("ns2:", "").replace(" xmlns:ns2=\"com.carerix.api\"", "");
    }

    public static String getEmployeeId(Document document) {
        return document.getElementsByTagName(CarerixModel.ELEMENTS.CREMPLOYEE).item(0).getAttributes().getNamedItem("id").getNodeValue();
    }

    public static String toGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            return "Man";
        }
        if ("Female".equalsIgnoreCase(gender)) {
            return "Vrouw";
        }
        if ("Undetermined".equalsIgnoreCase(gender)) {
            return "Onbekend";
        }
        return null;
    }

    public static String convertUser(CRUser user) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(user.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            QName qName = new QName("com.carerix.api", "CRUser");
            JAXBElement<CRUser> root = new JAXBElement<>(qName, CRUser.class, user);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(root, sw);
            return stripNamespaces(sw.toString());
        } catch (Exception ex) {
            log.info(ex.getMessage());
        }
        return null;
    }
}
