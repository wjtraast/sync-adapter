package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.api.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
public class OnlyOnceOutboundListenerService {



    @Autowired
    private OnlyOnceApiService onlyOnceApiService;

    @JmsListener(destination = "simple.queue")
    public void receiveOrder(Message message) {

        //onlyOnceApiService.dosomething();
        // send Message to OO API
    }
}
