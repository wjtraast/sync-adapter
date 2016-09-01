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
}
