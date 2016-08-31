package nl.onlyonce.adapter.service.batch;

import nl.onlyonce.adapter.model.message.BatchRequestMessage;

/**
 * @author: Gerben
 */
public interface BatchRequestService {

    void processRequest(BatchRequestMessage message);
}
