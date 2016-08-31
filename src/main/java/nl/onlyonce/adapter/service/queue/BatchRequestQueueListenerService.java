package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.BatchRequestMessage;

/**
 * @author: Gerben
 */
public interface BatchRequestQueueListenerService {

    void receiveMessage(BatchRequestMessage message);
}
