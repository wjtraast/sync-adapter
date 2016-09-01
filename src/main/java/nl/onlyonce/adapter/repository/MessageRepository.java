package nl.onlyonce.adapter.repository;

import nl.onlyonce.adapter.model.data.Message;
import nl.onlyonce.adapter.model.type.MessageStatusType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


/**
 * @author: Gerben
 */

public interface MessageRepository extends Repository<Message, Long> {

    Page<Message> findAll(Pageable pageable);

    Message findByStatus(MessageStatusType status);

    void markAsFailed(String id, String message);
    void markAsProcessed(String id);
}