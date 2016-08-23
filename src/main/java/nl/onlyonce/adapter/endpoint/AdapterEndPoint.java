package nl.onlyonce.adapter.endpoint;


import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.service.OnlyOnceApiService;
import nl.onlyonce.adapter.service.SalesforceOutboundService;
import nl.onlyonce.adapter.model.type.AdapterType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author: Gerben
 */

@Controller
@EnableAutoConfiguration
public class AdapterEndPoint {


    @Autowired
    SalesforceOutboundService salesforceOutboundService;

    @Autowired
    OnlyOnceApiService onlyOnceApiService;

    @RequestMapping("/process")
    @ResponseBody
    String process() {

        AdapterType type = AdapterType.SALESFORCE_ADAPTER;

        switch (type) {

            case SALESFORCE_ADAPTER:
                List<Activity> activities = onlyOnceApiService.getActivityList(type);
                salesforceOutboundService.process(activities);
                break;

        }
        return "done";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdapterEndPoint.class, args);
    }
}