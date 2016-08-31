package nl.onlyonce.adapter.model;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.type.TargetType;

import java.io.Serializable;

/**
 * @author: Gerben
 */
@Data
@Builder
public class SyncEvent implements Serializable {

    private String id;
    private Command adapterCommand;
    private TargetType adapterType;

}
