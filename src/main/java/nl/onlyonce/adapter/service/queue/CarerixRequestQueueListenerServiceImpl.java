package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.service.target.CarerixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
@Log
public class CarerixRequestQueueListenerServiceImpl implements CarerixRequestQueueListenerService {

    @Autowired
    CarerixService carerixService;

    @JmsListener(destination = "CarerixRequestQueue")
    public void receiveMessage(final CarerixRequestMessage message) {
        log.info("CarerixRequestMessage received ");
        carerixService.processMessage(message);
    }
}
