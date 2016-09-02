package nl.onlyonce.adapter.model.data;

import lombok.Data;
import nl.onlyonce.adapter.model.type.MessageStatusType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: Gerben
 */

@Entity
@Table(name = "syncmessage")
@Data
public class SyncMessage implements Serializable {


    public SyncMessage() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "messageid",nullable = false)
    private String messageId;

    @Column(name = "messagetype" ,nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageType messageType;

    @Column(name = "requestdate")
    private Date requestDate;

    @Column(name = "messagestatus", nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatusType messageStatus;

    @Column(name = "errormessage")
    private String errorMessage;

    @Column(name="message")
    private String message;



}
