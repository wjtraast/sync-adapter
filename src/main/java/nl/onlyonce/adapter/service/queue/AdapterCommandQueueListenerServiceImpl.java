package nl.onlyonce.adapter.service.queue;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.AdapterCommandMessage;
import nl.onlyonce.adapter.service.CommandHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */


@Component
@Log
public class AdapterCommandQueueListenerServiceImpl implements AdapterCommandQueueListenerService {

    @Autowired
    CommandHandlerService commandHandlerService;

    @JmsListener(destination = "CommandQueue")
    public void receiveCommand(AdapterCommandMessage command) {
        log.info("command received " + command.getAdapterCommand().toString());
        commandHandlerService.processCommand(command);
    }
}
