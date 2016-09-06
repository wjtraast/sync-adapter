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

        ZohoRequestMessage message = Fixtures.getFullZohoRequstMessage();
        String messageAsString = JsonUtil.convertToString(message);
        //assertThat(messageAsString).isEqualTo(expectedValue);

        System.out.println(messageAsString);




    }
}
