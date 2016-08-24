package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.AdapterCommandMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */
@Service
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
