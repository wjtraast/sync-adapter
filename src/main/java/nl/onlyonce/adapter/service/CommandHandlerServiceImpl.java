package nl.onlyonce.adapter.service;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.AdapterCommandMessage;
import nl.onlyonce.adapter.service.sync.CarerixSyncService;
import nl.onlyonce.adapter.service.sync.SalesforceSyncService;
import nl.onlyonce.adapter.service.sync.SohoSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */
@Service
@Log
public class CommandHandlerServiceImpl implements CommandHandlerService {

    @Autowired
    SalesforceSyncService salesforceSyncService;

    @Autowired
    SohoSyncService sohoSyncService;

    @Autowired
    CarerixSyncService carerixSyncService;

    @Override
    public void processCommand(final AdapterCommandMessage command) {


        switch (command.getAdapterType()) {
            case CARERIX:
                carerixSyncService.execute();
                break;
            case SALESFORCE:
                salesforceSyncService.execute();
                break;
            case SOHO:
                sohoSyncService.execute();
                break;
        }
    }
}
