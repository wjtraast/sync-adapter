package nl.onlyonce.adapter.service.target;

import org.junit.Test;

/**
 * @author: Gerben
 */

public class ZohoServiceImplTest {


    private ZohoServiceImpl service;


    @Test
    public void testTransformContact() {

//        Date SyncDate = new Date();
//        SimpleDateFormat dateFullFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//        String syncDateString = dateFullFormatter.format(SyncDate);
//
//        String data = "<Contacts><row no=\"1\">";
//        data = TestUtils.addFLElement(data, "<FL val=\"Salutation\">Male</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"First Name\">Jan</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"Last Name\">Jansen</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"Date of Birth\">20/02/1972</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"Mailing Street\">Kerkstraat</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"Title\">Ing. JJ</FL>");
//        data = TestUtils.addFLElement(data, "<FL val=\"Description\">Last synced by Only Once at " + syncDateString + "\nCard name: My Card</FL>");
//        data = data + "</row></Contacts>";
//
//        String EXPECTED_VALUE = data;
//        service = new ZohoServiceImpl();
//
//        ZohoRequestMessage message = Fixtures.getContactZohoRequestMessage();
//        ZohoContact contact = service.tranform(message, SyncDate);
//        String zohoXml = contact.toString();
//        System.out.println(zohoXml);
//        Assert.assertEquals(EXPECTED_VALUE, zohoXml);

    }

//    @Test
//    public void testTransformAccount() {
//
//        Date SyncDate = new Date();
//        SimpleDateFormat dateFullFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
//        String syncDateString = dateFullFormatter.format(SyncDate);
//
//        String EXPECTED_VALUE ="<Contacts><row no=\"1\"><FL val=\"Salutation\">Male</FL><FL val=\"First Name\">Jan</FL><FL val=\"Last Name\">Jansen</FL><FL val=\"Date of Birth\">20/02/1972</FL><FL val=\"Mailing Street\">Kerkstraat</FL><FL val=\"Title\">Ing. JJ</FL><FL val=\"Description\">Last synced by Only Once at " + syncDateString  + "\nCard name: My Card</FL></row></Contacts>";
//        //String EXPECTED_VALUE = "<Contacts><row no=\"1\"><FL val=\"Salutation\">Male</FL><FL val=\"First Name\">Jan</FL><FL val=\"Last Name\">Jansen</FL><FL val=\"Date of Birth\">20/02/1972</FL><FL val=\"Mailing Street\">Kerkstraat</FL><FL val=\"Title\">Ing. JJ</FL><FL val=\"Description\">Last synced by Only Once at " + syncDateString  + "\nCard name: My Card</FL></row></Contacts>";
//        service = new ZohoServiceImpl();
//
//        ZohoRequestMessage message = Fixtures.getAccountZohoRequestMessage();
//        ZohoContact contact = service.tranform(message, SyncDate);
//        String zohoXml = contact.toString();
//        System.out.println(zohoXml);
//        Assert.assertEquals(EXPECTED_VALUE, zohoXml);
//
//    }

}
