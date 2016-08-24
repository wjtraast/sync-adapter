package nl.onlyonce.adapter.service.outbound;

import nl.onlyonce.adapter.model.api.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */


/*

Deze service gaat een intere queue uitlezen en deze informatie naar OO Sturen.

 */
@Service
public class OnlyOnceOutboundProviderService {

    private static final String SIMPLE_QUEUE = "simple.queue";

    @Autowired
    JmsTemplate jmsTemplate;

//    @Autowired
//    public OnlyOnceOutboundProviderService(JmsTemplate jmsTemplate) {
//        this.jmsTemplate = jmsTemplate;
//    }


    public void addMessage(Message message) {
        jmsTemplate.convertAndSend(SIMPLE_QUEUE, message);
    }
}
