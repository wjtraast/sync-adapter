package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

/**
 * @author: Gerben
 */
public interface ZohoService {

    void processMessage(ZohoRequestMessage message);
}
