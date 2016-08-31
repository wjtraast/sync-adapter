package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.api.ZohoApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */

@Service
public class ZohoServiceImpl implements ZohoService {

    @Autowired
    private ZohoApiService zohoApiService;



    @Override
    public void processMessage(ZohoRequestMessage message) {


        // process ZohoRequestMessage

        // statusService.messageFailed(message);

        // statusService.messageProcessed(message);

    }
}
