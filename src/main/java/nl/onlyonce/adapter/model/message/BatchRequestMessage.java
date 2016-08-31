package nl.onlyonce.adapter.model.message;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.MetaData;
import nl.onlyonce.adapter.model.type.TargetType;

import java.util.List;

/**
 * @author: Gerben
 */

@Data
@Builder
public class BatchRequestMessage extends BaseRequestMessage {

    private MetaData metaData;
    private String messageId;



    public List<BaseRequestMessage> getRequests(TargetType targetType) {

        switch (targetType) {
            case CARERIX:;
            case ZOHO: break;
            default:break;
        }

        return null;


    }
}
