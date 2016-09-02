package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.data.MessageType;
import nl.onlyonce.adapter.model.data.SyncMessage;

/**
 * @author: Gerben
 */
public interface SyncMessageStoreService {


    SyncMessage save(String messageId, MessageType messageType, String message);

    SyncMessage markAsProcessed(String id);

    SyncMessage markAsFailed(String id, String errorMessage);

}
