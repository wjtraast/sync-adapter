package nl.onlyonce.adapter.service;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.data.MessageType;
import nl.onlyonce.adapter.model.data.SyncMessage;
import nl.onlyonce.adapter.model.type.MessageStatusType;
import nl.onlyonce.adapter.repository.SyncMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author: Gerben
 */

@Service
@Log
public class SyncMessageStoreServiceImpl implements SyncMessageStoreService {


    @Autowired
    private SyncMessageRepository syncMessageRepository;

    public SyncMessage save(String messageId, MessageType messageType, String message) {

        SyncMessage syncMessage = new SyncMessage();
        syncMessage.setMessageId(messageId);
        syncMessage.setMessageStatus(MessageStatusType.PENDING);
        syncMessage.setMessageType(messageType);
        syncMessage.setRequestDate(new Date());
        syncMessage.setMessage(message);
        return syncMessageRepository.save(syncMessage);
    }

    @Override
    public SyncMessage markAsProcessed(String id) {

        List<SyncMessage> messages = syncMessageRepository.findByMessageId(id);
        if (!CollectionUtils.isEmpty(messages)) {
            SyncMessage syncMessage = messages.get(0);
            syncMessage.setMessageStatus(MessageStatusType.PROCESSED);
            return syncMessageRepository.save(syncMessage);
        }
        return null;
    }

    @Override
    public SyncMessage markAsFailed(String id, String errorMessage) {

        List<SyncMessage> messages = syncMessageRepository.findByMessageId(id);
        if (!CollectionUtils.isEmpty(messages)) {
            SyncMessage syncMessage = messages.get(0);
            syncMessage.setMessageStatus(MessageStatusType.FAILED);
            syncMessage.setErrorMessage(errorMessage);
            return syncMessageRepository.save(syncMessage);
        }
        return null;
    }


}
