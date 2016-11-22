package nl.onlyonce.adapter.model.message;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: Gerben
 */
@Data
public class SyncRequestMessage implements Serializable {

    public String id;
    public boolean syncZoho = false;
    public boolean syncCarerix = false;
}
