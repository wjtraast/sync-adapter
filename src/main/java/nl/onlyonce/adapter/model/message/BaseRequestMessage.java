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


    String id; // internal messageId

    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private String dateOfBirth;
    @JsonProperty
    private String initials;
    @JsonProperty
    private String gender;



    @JsonProperty
    private String mobile1;
    @JsonProperty
    private String mobile2;
    @JsonProperty
    private String mobile3;
    @JsonProperty
    private String landline1;
    @JsonProperty
    private String landline2;
    @JsonProperty
    private String landline3;
    @JsonProperty
    private String email1;
    @JsonProperty
    private String email2;

    @JsonProperty
    private String city;

    @JsonProperty
    private String postalCode;

    @JsonProperty
    private String houseNumber;

    @JsonProperty
    private String streetname1;
    @JsonProperty
    private String streetname2;


    @JsonProperty
    private String cardId;
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
