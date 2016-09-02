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
                case "account":
                    processZohoAccount(message);
                    break;
                case "contact":
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
            ZohoContact contact = tranform(message);
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
                .withField(ZohoFieldNames.Account.LASTNAME, message.getLastname());
        /*

        etc...
         */

    }

    static ZohoContact tranform(final ZohoRequestMessage message) {
        return ZohoContact.create()
                .withField(ZohoFieldNames.Contact.FIRSTNAME, message.getFirstname())
                .withField(ZohoFieldNames.Contact.LASTNAME, message.getLastname());


         /*

        etc...
         */

    }


}
