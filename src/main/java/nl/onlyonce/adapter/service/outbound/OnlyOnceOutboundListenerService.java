package nl.onlyonce.adapter.service.outbound;

import nl.onlyonce.adapter.model.api.Message;
import nl.onlyonce.adapter.service.OnlyOnceApiService;
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
