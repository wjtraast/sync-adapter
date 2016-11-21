package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.SyncRequestMessage;

/**
 * @author: Gerben
 */
public interface SyncRequestQueueProviderService {

    void addMessage(SyncRequestMessage message);

}
