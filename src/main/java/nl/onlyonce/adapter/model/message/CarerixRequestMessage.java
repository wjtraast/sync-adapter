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

    @JsonProperty
    private String currentSalary;

    @JsonProperty
    private String note1;

    @JsonProperty
    private String note2;

    @JsonProperty
    private String jobTitle;

//    @JsonProperty(value = "resumes")
//    private List<ResumeWrapper> resumes;




    public boolean validate() {
        return true;
//        return (!StringUtils.isEmpty(getFirstname()) ||
//                !StringUtils.isEmpty(getLastname()));
    }
}

