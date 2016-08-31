package nl.onlyonce.adapter.model.zoho;

import lombok.Builder;
import lombok.Data;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;

/**
 * @author: Gerben
 */
@Builder
@Data
public class ZohoUser {

    private String firstname;
    private String lastname;
    private String emailAddress;


    /*
    must be in Builder class for ZohoUser, for now easy like this..

     */
    public static ZohoUser fromMessage(final ZohoRequestMessage message) {

        return ZohoUser.builder()
                .emailAddress(message.getEmailAddress())
                .firstname(message.getFirstname())
                .lastname(message.getLastname())
                .build();


    }
}
