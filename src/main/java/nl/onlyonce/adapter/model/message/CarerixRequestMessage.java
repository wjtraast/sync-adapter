package nl.onlyonce.adapter.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: Gerben
 */
//@Builder
@Data
public class CarerixRequestMessage extends BaseRequestMessage {

    public CarerixRequestMessage() {

    }


    @JsonProperty
    private String availableFromDate;



    public boolean validate() {
        return true;
//        return (!StringUtils.isEmpty(getFirstname()) ||
//                !StringUtils.isEmpty(getLastname()));
    }
}
