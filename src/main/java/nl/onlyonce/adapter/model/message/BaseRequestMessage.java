package nl.onlyonce.adapter.model.message;

import lombok.Data;
import nl.onlyonce.adapter.model.FieldValue;

import java.io.Serializable;
import java.util.Map;

/**
 * @author: Gerben
 */
@Data
public class BaseRequestMessage implements Serializable {

    private String id;
    private String firstname;
    private String lastname;
    private String emailAddress;

    private Map<String, FieldValue> customFields;
}
