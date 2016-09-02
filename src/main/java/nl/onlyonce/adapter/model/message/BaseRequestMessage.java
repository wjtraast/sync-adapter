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


    String id; // messageId


    Map<String, FieldValue> customFields;
}
