package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.zoho.FieldList;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import nl.onlyonce.adapter.model.zoho.ZohoFieldNames;
import nl.onlyonce.adapter.service.api.ZohoApiService;
import nl.onlyonce.adapter.service.api.ZohoApiServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Gerben
 */

@RunWith(SpringRunner.class)
public class ZohoApiServiceImplTest {


    @Autowired
    private ZohoApiService service;

    @Test
    public void testFindContact() throws Exception {

        //service = new ZohoApiServiceImpl();

        ZohoContact contact = service.findContact("test@test66.nl", "123");
        System.out.println(contact);

    }

    @Test
    public void testInsertContact() throws Exception {

        service = new ZohoApiServiceImpl();

        ZohoContact contact = new ZohoContact();

        FieldList fieldList = new FieldList(1L);
        fieldList.addField(ZohoFieldNames.Contact.FIRSTNAME, "Hans");
        fieldList.addField(ZohoFieldNames.Contact.LASTNAME, "Bakker");
        fieldList.addField(ZohoFieldNames.Contact.DATE_OF_BIRTH, "02/20/1930");
        fieldList.addField(ZohoFieldNames.Contact.FIRSTNAME, "Hans");
        fieldList.addField(ZohoFieldNames.Contact.EMAIL1, "hb112424@124124124.nl");
        contact.setFieldList(fieldList);
        service.insertContact(contact);
        System.out.println(contact);

    }

    @Test
    public void testUpdateContact() throws Exception {

        service = new ZohoApiServiceImpl();

        ZohoContact contact = service.findContact("test@test66.nl", "123");

        contact.getFieldList().getFieldByName(ZohoFieldNames.Contact.LASTNAME).setValue("habbyhab");
        service.updateContact(contact);

    }

}
