package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.SyncRequestMessage;

/**
 * @author: Gerben
 */
public interface SyncService {

    void processMessage(SyncRequestMessage message);
}
