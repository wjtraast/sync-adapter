package nl.onlyonce.adapter.model.carerix;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * @author: Gerben
 */

/*

<CRUser><importID>1234</importID></CRUser>


 */

@XmlRootElement(name = "CRUser")
public class CarerixUser {

    private String importID;


    public static void main(String[] args) {

        CarerixUser user = new CarerixUser();
        user.setImportID("1234");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(CarerixUser.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            java.io.StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(user, sw);
            System.out.println(sw.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public String getImportID() {
        return importID;
    }

    @XmlElement(name = "importID")
    public void setImportID(String importID) {
        this.importID = importID;
    }
}
