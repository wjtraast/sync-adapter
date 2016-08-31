package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.CarerixRequestMessage;

/**
 * @author: Gerben
 */
public interface CarerixRequestQueueProviderService {

    void addMessage(CarerixRequestMessage message);

}
