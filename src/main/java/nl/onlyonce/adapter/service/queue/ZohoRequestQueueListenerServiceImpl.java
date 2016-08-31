package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.target.ZohoOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
@Log
public class ZohoRequestQueueListenerServiceImpl implements BatchRequestQueueListenerService {

    @Autowired
    ZohoOutService zohoOutboundService;

    @JmsListener(destination = "ZohoRequestQueue")
    public void receiveCommand(ZohoRequestMessage message) {
        log.info("request received ");
        zohoOutboundService.processMessage(message);
    }
}
