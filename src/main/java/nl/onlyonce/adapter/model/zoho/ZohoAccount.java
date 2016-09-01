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

@XmlRootElement(name = "Accounts")
public class ZohoAccount extends ZohoRecord {


    /*




https://crm.zoho.com/crm/private/xml/Accounts/insertRecords?authtoken=Auth Token&scope=crmapi
&newFormat=1
&xmlData=

<Accounts>
<row no="1">
<FL val="Account Name">Zillum</FL>
<FL val="Website">www.zillum.com</FL>
<FL val="Employees">200</FL>
<FL val="Ownership">Private</FL>
<FL val="Industry">Real estate</FL>
<FL val="Fax">99999999</FL>
<FL val="Annual Revenue">20000000</FL>
</row>
</Accounts>



     */

    public static ZohoAccount fromMessage(final ZohoRequestMessage message) {
        return null;
    }

    public static void main(String[] args) {

        ZohoAccount accounts = ZohoAccount.create()
                .withField(ZohoFieldNames.Account.FIRSTNAME, "Gerben")
                .withField(ZohoFieldNames.Account.DATE_OF_BIRTH, "20/02/1972");

        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(ZohoAccount.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            java.io.StringWriter sw = new StringWriter();
            jaxbMarshaller.marshal(accounts, sw);
            System.out.println(sw.toString());

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public ZohoAccount withField(String label, String value) {
        this.addField(label, value);
        return this;
    }

    public static ZohoAccount create() {
        ZohoAccount accounts = new ZohoAccount();
        return accounts;

    }



}
