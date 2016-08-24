package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.AdapterCommandMessage;

/**
 * @author: Gerben
 */
public interface AdapterCommandQueueProviderService {

    void addMessage(AdapterCommandMessage message);
}
