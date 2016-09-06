package nl.onlyonce.adapter.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: Gerben
 */
@Data
@ToString
public class ZohoRequestMessage extends BaseRequestMessage {

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat dateFullFormatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

    @JsonProperty
    private String type;
    @JsonProperty
    private String dateOfBirth;
    @JsonProperty
    private String initials;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private String salutation;
    @JsonProperty
    private String academicTitle;
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
    private String streetname;
    @JsonProperty
    private String postalcode;
    @JsonProperty
    private String region;
    @JsonProperty
    private String city;
    @JsonProperty
    private String country;
    @JsonProperty
    private String jobPosition;
    @JsonProperty
    private String flexAvailabilityFrom;
    @JsonProperty
    private String flexAvailabilityTo;
    @JsonProperty
    private String hourlyRate;
    @JsonProperty
    private String minHourRate;
    @JsonProperty
    private String skills;
    @JsonProperty
    private String tradeName;

    @JsonProperty
    private String skypeId;
    @JsonProperty
    private String Linkedin;
    @JsonProperty
    private String Website;
    private Object lastSyncDescription;


    public ZohoRequestMessage() {

    }

    public Date getDateOfBirthAsDate() {
        try {
            return dateFormatter.parse(dateOfBirth);
        } catch (ParseException e) {
            return null;
        }


    }

    public boolean isPds() {
        return "pds".equalsIgnoreCase(type);
    }

    public boolean isOds() {
        return "ods".equalsIgnoreCase(type);
    }

    public boolean isTypeAllowed() {
        return isOds() || isPds();
    }

    public boolean validate() {
        if (!isTypeAllowed()) {
            return false;
        }

        if (isOds() && StringUtils.isEmpty(tradeName)) {
            return false;
        }

        if (isPds() && StringUtils.isEmpty(firstname) || StringUtils.isEmpty(lastname)) {
            return false;
        }
        return false;
    }

    public String combineTitleFields(String initials, String academicTitle) {
        if (StringUtils.isEmpty(initials)) {
            return academicTitle;
        }

        if (StringUtils.isEmpty(academicTitle)) {
            return initials;
        }

        if (!StringUtils.isEmpty(initials) && !StringUtils.isEmpty(academicTitle)) {
            return academicTitle + " " + initials;
        }
        return null;
    }

    public String getLastSyncDescription(Date date) {
        return "Last synced by Only Once at " + dateFullFormatter.format(date) +  "\nCard name: " + cardname;
    }
}
