package nl.onlyonce.adapter.service.target;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.zoho.ZohoAccount;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import nl.onlyonce.adapter.model.zoho.ZohoFieldNames;
import nl.onlyonce.adapter.repository.SyncMessageRepository;
import nl.onlyonce.adapter.service.SyncMessageStoreService;
import nl.onlyonce.adapter.service.api.ZohoApiException;
import nl.onlyonce.adapter.service.api.ZohoApiService;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: Gerben
 */

@Service
@Log
public class ZohoServiceImpl implements ZohoService {

    @Autowired
    private ZohoApiService zohoApiService;

    @Autowired
    private SyncMessageStoreService syncMessageStoreService;

    @Autowired
    private SyncMessageRepository messageRepository;

//    public ZohoServiceImpl() {
//
//    }
//
//    public ZohoServiceImpl(SyncMessageRepository messageRepository, ZohoApiService zohoApiService) {
//        this.messageRepository = messageRepository;
//        this.zohoApiService = zohoApiService;
//    }

    @Override
    public void processMessage(ZohoRequestMessage message) {

        if (message.getType() != null) {
            switch (message.getType().toLowerCase()) {
                case "ods":
                    processZohoAccount(message);
                    break;
                case "pds":
                    processZohoContact(message);
                    break;
            }
        }
    }

    private void processZohoAccount(final ZohoRequestMessage message) {



        try {
            ZohoAccount account = transform(message);


            zohoApiService.insertAccount(account);
            syncMessageStoreService.markAsProcessed(message.getId());
        } catch (ZohoApiException | HttpException e) {
            log.info(e.getMessage()); // must be error logging !
            syncMessageStoreService.markAsFailed(message.getId(), e.getMessage());
        }
    }

    private void processZohoContact(final ZohoRequestMessage message) {

        try {
           // zohoApiService.findContact(message.getLastname(), message.getEmail1(), message.getEmail2());



            ZohoContact contact = tranform(message, new Date());


            zohoApiService.insertContact(contact);
            syncMessageStoreService.markAsProcessed(message.getId());
        } catch (ZohoApiException | HttpException e) {
            log.info(e.getMessage());// must be error logging !
            syncMessageStoreService.markAsFailed(message.getId(), e.getMessage());
        }
    }


    static ZohoAccount transform(final ZohoRequestMessage message) {
        return ZohoAccount.create()
                .withField(ZohoFieldNames.Account.FIRSTNAME, message.getFirstname())
                .withField(ZohoFieldNames.Account.LASTNAME, message.getLastname())
                .withField(ZohoFieldNames.Account.BILLING_STREET, message.combineStreetNameFields(message.getStreetname1(), message.getStreetname2(), message.getHousenumber()))
                .withField(ZohoFieldNames.Account.BILLING_CODE, message.getPostalcode())
                .withField(ZohoFieldNames.Account.BILLING_STATE, message.getRegion())
                .withField(ZohoFieldNames.Account.BILLING_COUNTRY, message.getCountry());

        /*

			"trade_name": "",
			"company_communication_mobtel1": "Phone",
			"company_communication_mobtel2": "Phone",
			"company_communication_mobtel2": "Phone",
			"company_communication_landline1": "Phone",
			"company_communication_landline2": "Phone",
			"company_communication_landline3": "Phone",
			"company_communication_email1": "E-mail",
			"company_communication_email2": "E-mail",
			"company_communication_email3": "E-mail",
			"company_street_name": "Billing Street",
			"company_postal_code": "Billing Code",
			"company_city": "Billing City",
			"company_region": "Billing State",
			"company_country": "Billing Country"
         */

    }

    static ZohoContact tranform(final ZohoRequestMessage message, Date date) {
        return ZohoContact.create()
                .withField(ZohoFieldNames.Contact.SALUTATION, message.getSalutation(), ZohoFieldNames.Contact.SALUTATION_NULL_VALUE)
                .withField(ZohoFieldNames.Contact.FIRSTNAME, message.combineFirstNameFields(message.getGender(), message.getFirstname()))
                .withField(ZohoFieldNames.Contact.LASTNAME, message.combineLastNameFields(message.getLastname(), message.getAcademicSuffix()))
                .withField(ZohoFieldNames.Contact.DATE_OF_BIRTH, message.getDateOfBirth())
                .withField(ZohoFieldNames.Contact.MAILING_STREET, message.combineStreetNameFields(message.getStreetname1(), message.getStreetname2(), message.getHousenumber()))
                .withField(ZohoFieldNames.Contact.TITLE, message.combineTitleFields(message.getInitials(), message.getAcademicTitle()))
                .withField(ZohoFieldNames.Contact.DESCRIPTION, message.getLastSyncDescription(date))
                .withField(ZohoFieldNames.Contact.EMAIL1, message.getEmail1())
                .withField(ZohoFieldNames.Contact.EMAIL2, message.getEmail2())
                .withField(ZohoFieldNames.Contact.PHONE, message.getLandline1())
                .withField(ZohoFieldNames.Contact.HOME_PHONE, message.getLandline2())
                .withField(ZohoFieldNames.Contact.OTHER_PHONE, message.getLandline3())
                .withField(ZohoFieldNames.Contact.MOBILE, message.getMobile1())
                .withField(ZohoFieldNames.Contact.SKYPEID, message.getSkypeId())
                .withField(ZohoFieldNames.Contact.TWITTER, message.getTwitter())

                .withField(ZohoFieldNames.Contact.MAILING_CITY, message.getCity())
                .withField(ZohoFieldNames.Contact.MAILING_COUNTRY, message.getCountry())
                .withField(ZohoFieldNames.Contact.MAILING_ZIP, message.getPostalcode())
                .withField(ZohoFieldNames.Contact.MAILING_REGION, message.getRegion())

                .withField(ZohoFieldNames.Contact.Custom.SYNCED_BY_ONLYONCE, "true");





         /*


         switch(fieldName) {
							case "date_of_birth":
								var date = card.fields[fieldName].split("-");
								xmlData += date[1]+"/"+date[0]+"/"+date[2];
							break;
							case "company_street_name":
								xmlData += card.fields[fieldName]+(card.fields.hasOwnProperty("company_house_number") ? " "+card.fields['company_house_number'] : "");
							break;
							case "street_name":
								xmlData += card.fields[fieldName]+(card.fields.hasOwnProperty("house_number") ? " "+card.fields['house_number'] : "");
							break;
							case "initials":
								xmlData += (card.fields.hasOwnProperty("academic_title") ? card.fields['academic_title']+" " : "")+card.fields[fieldName];
							break;
							case "academic_title":
								xmlData += card.fields[fieldName]+(card.fields.hasOwnProperty("initials") ? " "+card.fields['initials']+" " : "");
							break;
							case "willing_to_work_abroad":
								xmlData += (card.fields[fieldName] == "Yes" ? "true" : "false");
							break;
							case "gender":
								xmlData += (card.fields[fieldName] == "Male" ? "De heer" : "Mevrouw");
							break;
							case "flex_availability_to":
								var date = card.fields[fieldName].split("-");
								xmlData += date[1]+"/"+date[0]+"/"+date[2];
							break;
							case "flex_availability_from":
								var date = card.fields[fieldName].split("-");
								xmlData += date[1]+"/"+date[0]+"/"+date[2];
							break;
							default:
								xmlData += card.fields[fieldName];
							break;



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

        etc...
         */

    }


}
