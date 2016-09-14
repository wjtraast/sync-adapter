package nl.onlyonce.adapter.model.message;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Gerben
 */

@Data
@Builder
public class BatchRequestMessage extends BaseRequestMessage {

    private String messageId;
    private List<CarerixRequestMessage> carerixMessages;
    private List<ZohoRequestMessage> zohoMessages;

    public List<CarerixRequestMessage> getCarerixRequests() {

        List<CarerixRequestMessage> returnValue = new ArrayList<>();

        /*
        TODO verder uitwerken,

         */

        CarerixRequestMessage message = new CarerixRequestMessage();
        returnValue.add(message);
        return returnValue;


    }

    public List<ZohoRequestMessage> getZohoRequests() {
        return Collections.EMPTY_LIST;
    }



}
