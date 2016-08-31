package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.BatchRequestMessage;

/**
 * @author: Gerben
 */
public interface BatchRequestQueueProviderService {

    void addMessage(BatchRequestMessage message);

}
