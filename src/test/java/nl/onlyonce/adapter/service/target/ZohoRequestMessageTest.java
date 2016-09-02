package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.util.JsonUtil;
import org.junit.Test;

/**
 * @author: Gerben
 */
public class ZohoRequestMessageTest {



    @Test
    public void testZohoRequestMessage() throws Exception {

        //String expectedValue = "{\"id\":null,\"firstname\":\"Jan\",\"lastname\":\"Jansen\",\"emailAddress\":null,\"customFields\":null,\"type\":null,\"dateOfBirth\":null,\"gender\":null,\"title\":null}";

        /*

        "{
  "id" : null,
  "firstname" : "Jan",
  "lastname" : "Jansen",
  "emailAddress" : null,
  "customFields" : null,
  "type" : null,
  "dateOfBirth" : null,
  "gender" : null,
  "title" : null
}"


         */
        ZohoRequestMessage message = new ZohoRequestMessage();
        message.setFirstname("Jan");
        message.setLastname("Jansen");


        String messageAsString = JsonUtil.convertToString(message);
        //assertThat(messageAsString).isEqualTo(expectedValue);

        System.out.println(messageAsString);




    }
}
