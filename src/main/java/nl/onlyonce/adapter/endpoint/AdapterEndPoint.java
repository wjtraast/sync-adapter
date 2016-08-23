package nl.onlyonce.adapter.endpoint;


import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.AdapterType;
import nl.onlyonce.adapter.service.OnlyOnceApiService;
import nl.onlyonce.adapter.service.SalesforceOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @author: Gerben
 */

@RestController
public class AdapterEndPoint {


    @Autowired
    SalesforceOutboundService salesforceOutboundService;

    @Autowired
    OnlyOnceApiService onlyOnceApiService;

    @RequestMapping("/")
    String process() {

        AdapterType type = getType();

        switch (type) {

            case SALESFORCE_ADAPTER:
                List<Activity> activities = onlyOnceApiService.getActivities(type);
                activities = salesforceOutboundService.prepareData(activities);
                salesforceOutboundService.process(activities);
                break;

        }
        return "done";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AdapterEndPoint.class, args);
    }

    public AdapterType getType() {
        return AdapterType.SALESFORCE_ADAPTER; // uitlezen uit env. nu even fixed om te testen.

    }
}