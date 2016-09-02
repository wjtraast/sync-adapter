package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author: Gerben
 */

public class ZohoServiceImplTest {


    private ZohoServiceImpl service;


    @Test
    public void testTransformContact() {

        String EXPECTED_VALUE = "<Contacts><row no=\"1\"><FL val=\"First Name\">Jan</FL><FL val=\"Last Name\">Jansen</FL></row></Contacts>";
        service = new ZohoServiceImpl();
        ZohoRequestMessage requestMessage = new ZohoRequestMessage();
        requestMessage.setFirstname("Jan");
        requestMessage.setLastname("Jansen");
        ZohoContact contact = service.tranform(requestMessage);
        String zohoContactXml = contact.toString();
        Assert.assertEquals(EXPECTED_VALUE, zohoContactXml);

    }

}
