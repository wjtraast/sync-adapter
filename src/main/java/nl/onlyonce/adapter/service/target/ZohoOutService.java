package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

/**
 * @author: Gerben
 */
public interface ZohoOutService {

    void processMessage(ZohoRequestMessage message);
}
