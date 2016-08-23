package nl.onlyonce.adapter.service;


import com.force.api.ApiConfig;
import com.force.api.ForceApi;
import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.salesforce.Account;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Gerben
 */
@Service
public class SalesforceOutboundServiceImpl implements SalesforceOutboundService {

    private ForceApi api;

    //https://github.com/jesperfj/force-rest-api
    //https://help.salesforce.com/apex/HTViewHelpDoc?id=remoteaccess_oauth_username_password_flow.htm&language=en

    private ForceApi getForceApi() {

        if (api == null) {
            api = new ForceApi(new ApiConfig()
                    .setUsername("user@domain.com")
                    .setPassword("password")
                    .setClientId("longclientidalphanumstring")
                    .setClientSecret("notsolongnumeric"));
        }
        return api;

    }


    @Override
    public void process(List<Activity> activities) {

        Account a = new Account();
        a.setName("Test account");
        String id = getForceApi().createSObject("account", a);

    }

    @Override
    public List<Activity> prepareData(List<Activity> activities) {
        return null;
    }
}
