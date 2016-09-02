package nl.onlyonce.adapter.service.target;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author: Gerben
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyWebIntegrationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSyncEndPoint() {
        String body = this.restTemplate.getForObject("/sync-adapter/sync", String.class);
        assertThat(body).isEqualTo("running");
    }


}
