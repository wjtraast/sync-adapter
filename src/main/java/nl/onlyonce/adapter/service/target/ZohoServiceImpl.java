package nl.onlyonce.adapter.service.target;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.zoho.ZohoAccount;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import nl.onlyonce.adapter.model.zoho.ZohoFieldNames;
import nl.onlyonce.adapter.repository.MessageRepository;
import nl.onlyonce.adapter.service.api.ZohoApiException;
import nl.onlyonce.adapter.service.api.ZohoApiService;
import org.apache.commons.httpclient.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */

@Service
@Log
public class ZohoServiceImpl implements ZohoService {

    @Autowired
    private ZohoApiService zohoApiService;

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void processMessage(ZohoRequestMessage message) {

        switch (message.getType()) {
            case ACCOUNT:
                processZohoAccount(message);
                break;
            case CONTACT:
                processZohoContact(message);
                break;
        }
    }

    private void processZohoAccount(final ZohoRequestMessage message) {

        try {
            ZohoAccount account = ZohoAccount.create()
                    .withField(ZohoFieldNames.Account.FIRSTNAME, message.getFirstname())
                    .withField(ZohoFieldNames.Account.DATE_OF_BIRTH, message.getBirthDateAsString());


            zohoApiService.insertAccount(account);
            messageRepository.markAsProcessed(message.getId());
        } catch (ZohoApiException | HttpException e) {
            log.info(e.getMessage()); // must be error logging !
            messageRepository.markAsFailed(message.getId(), e.getMessage());
        }
    }


    private void processZohoContact(final ZohoRequestMessage message) {

        try {
            ZohoContact contact = ZohoContact.create()
                    .withField(ZohoFieldNames.Contact.FIRSTNAME, message.getFirstname())
                    .withField(ZohoFieldNames.Contact.DATE_OF_BIRTH, message.getBirthDateAsString());

            /*
            verder opbouwen van object
             */

            zohoApiService.insertContact(contact);
            messageRepository.markAsProcessed(message.getId());
        } catch (ZohoApiException | HttpException e) {
            log.info(e.getMessage());// must be error logging !
            messageRepository.markAsFailed(message.getId(), e.getMessage());
        }


    }
}
