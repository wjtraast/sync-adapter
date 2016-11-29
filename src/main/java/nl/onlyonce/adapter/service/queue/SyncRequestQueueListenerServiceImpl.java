package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.SyncRequestMessage;
import nl.onlyonce.adapter.service.target.SyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author: Gerben
 */

@Service
@Log
public class SyncRequestQueueListenerServiceImpl implements SyncRequestQueueListenerService {

    @Autowired
    SyncService syncService;

    @JmsListener(destination = "SyncRequestQueue")
    public void receiveMessage(SyncRequestMessage message) {
        log.info("request received ");
        message.setId(UUID.randomUUID().toString());
        syncService.processMessage(message);
    }
}
