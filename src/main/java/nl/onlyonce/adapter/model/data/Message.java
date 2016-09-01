package nl.onlyonce.adapter.model.data;

import lombok.Data;
import nl.onlyonce.adapter.model.type.MessageStatusType;
import org.mapstruct.TargetType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: Gerben
 */

@Entity
@Data
public class Message implements Serializable {


    protected Message() {
        // no-args constructor required by JPA spec
        // this one is protected since it shouldn't be used directly
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String messageId;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TargetType targetType;

    @Column
    private Date requestDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MessageStatusType messageStatus;

    @Column
    private String errorMessage;



}
