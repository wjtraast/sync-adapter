package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.type.QueueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */
@Component
@Log
public class CarerixRequestQueueProviderServiceImpl implements CarerixRequestQueueProviderService {


    private static final QueueName QUEUE = QueueName.CarerixRequestQueue;

    @Autowired
    JmsTemplate jmsTemplate;

//    @Autowired
//    public OnlyOnceOutboundProviderService(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }

    @Override
    public void addMessage(final CarerixRequestMessage message) {
        jmsTemplate.convertAndSend(QUEUE.toString(), message);
    }

}
