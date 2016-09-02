package nl.onlyonce.adapter.repository;

import nl.onlyonce.adapter.model.data.SyncMessage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author: Gerben
 */
@Repository
public interface SyncMessageRepository extends CrudRepository<SyncMessage, Long> {

    @Query("select m from SyncMessage m where m.messageId = :id")
    List<SyncMessage> findByMessageId(@Param("id") String id);


//    void markAsFailed(String id, String message);
//    void markAsProcessed(String id);
}