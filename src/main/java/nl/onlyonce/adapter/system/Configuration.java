package nl.onlyonce.adapter.system;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
@Data
public class Configuration {

    @Value("${name}")
    private String name;
}
