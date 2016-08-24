package nl.onlyonce.adapter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: Gerben
 */

@Component
public class Configuration {

    @Value("${name}")
    public String name;
}
