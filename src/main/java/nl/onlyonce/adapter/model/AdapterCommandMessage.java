package nl.onlyonce.adapter.model;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.type.AdapterType;

import java.io.Serializable;

/**
 * @author: Gerben
 */
@Data
@Builder
public class AdapterCommandMessage implements Serializable {

    private String id;
    private AdapterCommand adapterCommand;
    private AdapterType adapterType;

}
