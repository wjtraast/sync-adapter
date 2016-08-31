package nl.onlyonce.adapter.model.message;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.MetaData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: Gerben
 */

@Data
@Builder
public class BatchRequestMessage extends BaseRequestMessage {

    private MetaData metaData;
    private String messageId;
    private List<CarerixRequestMessage> carerixMessages;
    private List<ZohoRequestMessage> zohoMessages;



    public List<CarerixRequestMessage> getCarerixRequests() {

        List<CarerixRequestMessage> returnValue = new ArrayList<CarerixRequestMessage>();
        CarerixRequestMessage message = new CarerixRequestMessage();
        returnValue.add(message);
        return returnValue;


    }

    public List<ZohoRequestMessage> getZohoRequests() {
        return Collections.EMPTY_LIST;
    }



}
