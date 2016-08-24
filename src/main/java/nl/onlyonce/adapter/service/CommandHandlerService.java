package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.AdapterCommandMessage;

/**
 * @author: Gerben
 */
public interface CommandHandlerService {

    void processCommand(AdapterCommandMessage command);
}
