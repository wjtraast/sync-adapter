package nl.onlyonce.adapter.model.message;

import lombok.Builder;
import lombok.Data;

/**
 * @author: Gerben
 */
@Builder
@Data
public class CarerixRequestMessage extends BaseRequestMessage {

    public CarerixRequestMessage() {

    }



    public boolean validate() {
        return true;
//        return (!StringUtils.isEmpty(getFirstname()) ||
//                !StringUtils.isEmpty(getLastname()));
    }
}
