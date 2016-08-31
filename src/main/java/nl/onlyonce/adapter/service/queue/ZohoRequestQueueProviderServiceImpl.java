package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.type.QueueName;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */
@Component
@Log
public class ZohoRequestQueueProviderServiceImpl implements ZohoRequestQueueProviderService {

    private static final QueueName QUEUE = QueueName.ZohoRequestQueue;

    @Override
    public void addMessage(final ZohoRequestMessage message) {

        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.convertAndSend(QUEUE.toString(), message);
    }

}
