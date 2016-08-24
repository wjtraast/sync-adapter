package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.AdapterCommandMessage;

/**
 * @author: Gerben
 */
public interface AdapterCommandQueueProviderService {

    void addMessage(AdapterCommandMessage message);
}
