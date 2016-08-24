package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.AdapterType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: Gerben
 */
public class SalesforceSyncServiceImpl implements SalesforceSyncService {

    @Autowired
    OnlyOnceApiService onlyOnceApiService;

    @Autowired
    SalesforceOutboundService salesforceOutboundService;

    @Override
    public void execute() {

        List<Activity> activities = onlyOnceApiService.getActivities(AdapterType.SALESFORCE_ADAPTER);
        activities = salesforceOutboundService.prepareData(activities);
        salesforceOutboundService.process(activities);

    }
}
