package nl.onlyonce.adapter.model.zoho;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * @author: Gerben
 */

@XmlRootElement
public class ErrorResponse {

    private Error error;

    private String uri;

    @XmlElement
    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }


    @XmlAttribute(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }


    private static String convertToString(final Object xmlObject) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(ErrorResponse.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);
        StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal(xmlObject, sw);
        return sw.toString();
    }


    public static void main (String[] args) throws Exception {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setUri("http://adsfasdf");
        Error error = new Error();
        error.setCode("1244");
        error.setMessage("this is a message");
        errorResponse.setError(error);

        String xml = convertToString(errorResponse);
        System.out.println(xml);


    }
}



/*



<response uri="/crm/private/xml/Contacts/insertRecords">
  <error>
    <code>4834</code>
    <message>Invalid Ticket Id</message>
  </error>
</response>


 */
