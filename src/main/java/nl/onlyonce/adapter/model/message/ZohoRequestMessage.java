package nl.onlyonce.adapter.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: Gerben
 */
@Data
@ToString
public class ZohoRequestMessage extends BaseRequestMessage {

    @JsonProperty
    private String type;
    @JsonProperty
    private Date dateOfBirth;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private String gender;
    @JsonProperty
    private String title;
    @JsonProperty
    private String emailAddress;

    public ZohoRequestMessage() {

    }

}
