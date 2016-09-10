package nl.onlyonce.adapter.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: Gerben
 */
@Data
public class BaseRequestMessage implements Serializable {


    String id; // messageId

    @JsonProperty
    protected String cardname;
    Map<String, String> customFields;

    public void addCustomField(String fieldName, boolean booleanValue) {
        customFields.put(fieldName, booleanValue ? "true" : "false");

    }

    public void addCustomField(String fieldName, String stringValue) {
        customFields.put(fieldName, stringValue);

    }

    public String getCustomField(String fieldName) {
        return customFields.get(fieldName);
    }
}
