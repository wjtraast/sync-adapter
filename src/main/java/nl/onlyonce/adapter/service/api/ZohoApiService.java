package nl.onlyonce.adapter.service.api;

import nl.onlyonce.adapter.model.zoho.ZohoAccount;
import nl.onlyonce.adapter.model.zoho.ZohoContact;
import org.apache.commons.httpclient.HttpException;

/**
 * @author: Gerben
 */
public interface ZohoApiService {


    void insertContact(ZohoContact contact) throws HttpException, ZohoApiException;

    void insertAccount(ZohoAccount account) throws HttpException, ZohoApiException;

    ZohoContact findContact(String emailAddress, String cardId) throws HttpException, ZohoApiException;

    void updateContact(ZohoContact contact) throws HttpException, ZohoApiException;
}
