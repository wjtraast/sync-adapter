package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.service.batch.BatchRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
@Log
public class CarerixRequestListenerServiceImpl implements BatchRequestListenerService {

    @Autowired
    BatchRequestService syncBatchRequestService;

    @JmsListener(destination = "CarerixRequestQueue")
    public void receiveCommand(BatchRequestMessage message) {
        log.info("request received ");
        syncBatchRequestService.processRequest(message);
    }
}
