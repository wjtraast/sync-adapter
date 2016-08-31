package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.model.type.QueueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */
@Component
@Log
public class BatchRequestQueueProviderServiceImpl implements BatchRequestQueueProviderService {

    private static final QueueName QUEUE = QueueName.BatchRequestQueue;

    @Autowired
    JmsTemplate jmsTemplate;

    @Override
    public void addMessage(final BatchRequestMessage message) {
        jmsTemplate.convertAndSend(QUEUE.toString(), message);
    }

}
