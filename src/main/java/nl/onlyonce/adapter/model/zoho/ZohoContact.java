package nl.onlyonce.adapter.model.zoho;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;

/**
 * @author: Gerben
 */

@XmlRootElement(name = "Contacts")
public class ZohoContact extends ZohoRecord {


    /*/





https://crm.zoho.com/crm/private/xml/Contacts/insertRecords?authtoken=Auth Token&scope=crmapi
&newFormat=1
&xmlData=

<Contacts>
<row no="1">
<FL val="First Name">Scott</FL>
<FL val="Last Name">James</FL>
<FL val="Email">test@test.com</FL>
<FL val="Department">CG</FL>
<FL val="Phone">999999999</FL>
<FL val="Fax">99999999</FL>
<FL val="Mobile">99989989</FL>
<FL val="Assistant">John</FL>
</row>
</Contacts>



     */



    public static ZohoContact fromMessage(final ZohoRequestMessage message) {
        return null;
    }

    public static void main(String[] args) {

        ZohoContact contact = ZohoContact.create()
                .withField(ZohoFieldNames.Account.FIRSTNAME, "Test user")
                .withField(ZohoFieldNames.Account.DATE_OF_BIRTH, "20/02/1972");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(ZohoContact.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(contact, sw);
            System.out.println(sw.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public ZohoContact withField(String label, String value) {
        this.addField(label, value);
        return this;
    }

    public static ZohoContact create() {
        return new ZohoContact();
    }
}


/*
required: [
			"first_name",
			"last_name"
		],
		mapping: {
			"first_name": "First Name",
			"last_name": "Last Name",
			"communication_mobtel1": "Mobile",
			"communication_mobtel2": "Mobile",
			"communication_mobtel3": "Mobile",
			"communication_landline1": "Phone",
			"communication_landline2": "Phone",
			"communication_landline3": "Phone",
			"communication_email1": "Email",
			"communication_email2": "Email",
			"communication_email3": "Email",
			"communication_skype": "Skype Id",
			"date_of_birth": "Date of Birth",
			"street_name": "Mailing Street",
			"postal_code": "Mailing Zip",
			"region": "Mailing State",
			"city": "Mailing City",
			"country": "Mailing Country",
			"job_position": "Function description",
			"flex_availability_from": "Flex Available per",
			"flex_availability_to": "Regular Available per",
			"indicative_hourly_rate": "Hourly Rate",
			"minimum_hourly_rate": "Min Hour Rate",
			"skills": "Expertise and skills",
			"academic_title": "Title",
			"initials": "Title",
			"gender": "Salutation"
		}
 */