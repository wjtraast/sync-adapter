package nl.onlyonce.adapter.service;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.AdapterCommandMessage;
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

    @Override
    public void processCommand(final AdapterCommandMessage command) {


        switch (command.getAdapterType()) {
            case SALESFORCE_ADAPTER:
                salesforceSyncService.execute();
                break;
            case SOHO_ADAPTER:
                salesforceSyncService.execute();
                break;
        }
    }
}
