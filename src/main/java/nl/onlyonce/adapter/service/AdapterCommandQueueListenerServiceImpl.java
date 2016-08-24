package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.AdapterCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */


@Component
public class AdapterCommandQueueListenerServiceImpl implements AdapterCommandQueueListenerService {

    @Autowired
    CommandHandlerService commandProcessService;

    @JmsListener(destination = "commandQueue")

    public void receiveCommand(AdapterCommandMessage command) {
        commandProcessService.processCommand(command);
    }
}
