package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.SyncRequestMessage;

/**
 * @author: Gerben
 */
public interface SyncRequestQueueListenerService {

    void receiveMessage(SyncRequestMessage message);

}
