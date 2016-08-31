package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.CarerixRequestMessage;

/**
 * @author: Gerben
 */
public interface CarerixRequestQueueListenerService {

    void receiveMessage(final CarerixRequestMessage message);
}