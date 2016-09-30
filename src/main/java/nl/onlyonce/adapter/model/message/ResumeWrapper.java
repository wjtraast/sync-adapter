package nl.onlyonce.adapter.model.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Gerben
 */

@Data
public class ResumeWrapper implements Serializable {

    @JsonProperty
    String filename;

    @JsonProperty(value="file-content")
    String fileContent;
}
