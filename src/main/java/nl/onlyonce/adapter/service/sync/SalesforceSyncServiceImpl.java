package nl.onlyonce.adapter.service.sync;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.AdapterType;
import nl.onlyonce.adapter.service.OnlyOnceApiService;
import nl.onlyonce.adapter.service.SalesforceOutboundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Gerben
 */

@Service
@Log
public class SalesforceSyncServiceImpl implements SalesforceSyncService {

    @Autowired
    OnlyOnceApiService onlyOnceApiService;

    @Autowired
    SalesforceOutboundService salesforceOutboundService;

    @Override
    public void execute() {

        log.info("execute salesforce Sync service");
        List<Activity> activities = onlyOnceApiService.getActivities(AdapterType.SALESFORCE);
        activities = salesforceOutboundService.prepareData(activities);
        salesforceOutboundService.process(activities);

    }
}
