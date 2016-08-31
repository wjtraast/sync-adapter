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
public class BatchRequestQueueListenerServiceImpl implements BatchRequestQueueListenerService {

    @Autowired
    BatchRequestService batchRequestService;

    @JmsListener(destination = "BatchRequestQueue")
    public void receiveMessage(BatchRequestMessage message) {
        log.info("BatchRequestMessage received ");
        batchRequestService.processRequest(message);
    }
}
