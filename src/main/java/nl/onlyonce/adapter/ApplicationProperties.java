package nl.onlyonce.adapter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */
@Component
@Data
public class ApplicationProperties {

    @Value("${onlyonce.api.url}")
    private String onlyOnceApiUrl;

    @Value("${onlyonce.api.username}")
    private String onlyOnceApiUsername;

    @Value("${onlyonce.api.password}")
    private String onlyOnceApiPassword;

    @Value("${onlyonce.api.secretkey}")
    private String onlyonceApiSecretKey;

    @Value("${zoho.token}")
    private String zohoToken;

    @Value("${zoho.url}")
    private String zohoUrl;
}
