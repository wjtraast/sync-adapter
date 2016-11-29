package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.util.JsonUtil;

/**
 * @author: Gerben
 */
public class ZohoRequestMessageTest {

    //@Test
    public void testContactZohoRequestMessage() throws Exception {

        ZohoRequestMessage message = Fixtures.getContactZohoRequestMessage();
        String messageAsString = JsonUtil.convertToString(message);
        //assertThat(messageAsString).isEqualTo(expectedValue);
        System.out.println(messageAsString);
    }

    //@Test
    public void testAccountZohoRequestMessage() throws Exception {

//        ZohoRequestMessage message = Fixtures.getAccountZohoRequestMessage();
//        String messageAsString = JsonUtil.convertToString(message);
//        //assertThat(messageAsString).isEqualTo(expectedValue);
//        System.out.println(messageAsString);
    }
}
