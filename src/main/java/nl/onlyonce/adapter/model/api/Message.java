package nl.onlyonce.adapter.model.api;

import java.io.Serializable;

/**
 * @author: Gerben
 */

public class Message implements Serializable {

    private static final long serialVersionUID = -797586847427389162L;

    private final String id;

    public Message(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}