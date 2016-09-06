package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Gerben
 */

public class ZohoServiceImplTest {


    private ZohoServiceImpl service;


    @Test
    public void testTransformContact() {

        Date SYNC_DATE = new Date();
        SimpleDateFormat dateFullFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String syncDateString = dateFullFormatter.format(SYNC_DATE);
        String EXPECTED_VALUE = "<Contacts><row no=\"1\"><FL val=\"Salutation\">Male</FL><FL val=\"First Name\">Jan</FL><FL val=\"Last Name\">Jansen</FL><FL val=\"Date of Birth\">20/02/1972</FL><FL val=\"Mailing Street\">Kerkstraat</FL><FL val=\"Title\">Ing. JJ</FL><FL val=\"Description\">Last synced by Only Once at " + syncDateString  + "\nCard name: My Card</FL></row></Contacts>";
        service = new ZohoServiceImpl();

        ZohoRequestMessage message = Fixtures.getFullZohoRequstMessage();
        ZohoContact contact = service.tranform(message, SYNC_DATE);
        String zohoContactXml = contact.toString();
        System.out.println(zohoContactXml);
        Assert.assertEquals(EXPECTED_VALUE, zohoContactXml);

    }

}
