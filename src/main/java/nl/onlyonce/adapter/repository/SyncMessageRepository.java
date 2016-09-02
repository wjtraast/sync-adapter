package nl.onlyonce.adapter.repository;

import nl.onlyonce.adapter.model.data.SyncMessage;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * @author: Gerben
 */
public interface SyncMessageRepository extends CrudRepository<SyncMessage, Long> {

    List<SyncMessage> findByStatus(String status);

    void markAsFailed(String id, String message);
    void markAsProcessed(String id);
}