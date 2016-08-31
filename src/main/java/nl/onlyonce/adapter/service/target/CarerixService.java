package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.CarerixRequestMessage;

/**
 * @author: Gerben
 */
public interface CarerixService {


    void processMessage(CarerixRequestMessage message);

}
