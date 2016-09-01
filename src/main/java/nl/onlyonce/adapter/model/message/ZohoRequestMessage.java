package nl.onlyonce.adapter.model.message;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.zoho.ZohoType;

/**
 * @author: Gerben
 */
@Data
@Builder
public class ZohoRequestMessage extends BaseRequestMessage {

    private ZohoType type;
    private String birthDateAsString;


    public String getBirthDateAsString() {
        return birthDateAsString;
    }
}
