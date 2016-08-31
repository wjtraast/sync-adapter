package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

/**
 * @author: Gerben
 */
public interface ZohoRequestQueueListenerService {

    void receiveMessage(ZohoRequestMessage message);

}
