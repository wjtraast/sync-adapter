package nl.onlyonce.adapter.system;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.jms.ConnectionFactory;

/**
 * @author: Gerben
 */
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class Application {


    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
