package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.target.ZohoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
@Log
public class ZohoRequestQueueListenerServiceImpl implements ZohoRequestQueueListenerService {

    @Autowired
    ZohoService zohoService;

    @JmsListener(destination = "ZohoRequestQueue")
    public void receiveMessage(ZohoRequestMessage message) {
        log.info("request received ");
        zohoService.processMessage(message);
    }
}
