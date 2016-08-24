package nl.onlyonce.adapter.service.queue;

import nl.onlyonce.adapter.model.AdapterCommandMessage;
import nl.onlyonce.adapter.model.type.QueueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */


@Component
public class AdapterCommandQueueProviderServiceImpl implements AdapterCommandQueueProviderService {

    private static final QueueName QUEUE = QueueName.CommandQueue;

    @Autowired
    JmsTemplate jmsTemplate;

//    @Autowired
//    public OnlyOnceOutboundProviderService(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }

    @Override
    public void addMessage(final AdapterCommandMessage message) {
        jmsTemplate.convertAndSend(QUEUE.toString(), message);
    }

}
