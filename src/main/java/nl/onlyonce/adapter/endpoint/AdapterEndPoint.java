package nl.onlyonce.adapter.endpoint;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author: Gerben
 */

@Controller
@EnableAutoConfiguration
public class AdapterEndPoint {

//    private final String ADAPTER_NAME =


    @RequestMapping("/")
    @ResponseBody
    String test() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdapterEndPoint.class, args);
    }
}