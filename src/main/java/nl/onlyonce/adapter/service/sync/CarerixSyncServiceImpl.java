package nl.onlyonce.adapter.service.sync;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.AdapterType;
import nl.onlyonce.adapter.service.CarerixOutboundService;
import nl.onlyonce.adapter.service.OnlyOnceApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Gerben
 */

@Service
@Log
public class CarerixSyncServiceImpl implements CarerixSyncService {

    @Autowired
    OnlyOnceApiService onlyOnceApiService;

    @Autowired
    CarerixOutboundService carerixOutboundService;

    @Override
    public void execute() {

        log.info("execute CARERIX Sync service");
        List<Activity> activities = onlyOnceApiService.getActivities(AdapterType.SALESFORCE);
        activities = carerixOutboundService.prepareData(activities);
        carerixOutboundService.process(activities);

    }
}
