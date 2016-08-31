package nl.onlyonce.adapter;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;
import java.util.HashSet;
import java.util.Set;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author: Gerben
 */
@SpringBootApplication
@ComponentScan
@EnableSwagger2
public class Application {

    private Set<ErrorPage> pageHandlers;

    @PostConstruct
    private void init(){
        pageHandlers = new HashSet<ErrorPage>();
        pageHandlers.add(new ErrorPage(HttpStatus.NOT_FOUND,"/notfound.html"));
        pageHandlers.add(new ErrorPage(HttpStatus.FORBIDDEN,"/forbidden.html"));
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainer(){
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        factory.setPort(Integer.valueOf(8080));
        factory.setContextPath("/sync-adapter");
        factory.setErrorPages(pageHandlers);
        return factory;
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
    }

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                //.groupName("sync")
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring REST Sync Adapter")
                .description("Spring REST Sync Adapter")
                .termsOfServiceUrl("http://www.onlyonce.nl")
                .contact("")
                .license("")
                .licenseUrl("")
                .version("1.0")
                .build();
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
