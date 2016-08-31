package nl.onlyonce.adapter.service.batch;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.type.TargetType;
import nl.onlyonce.adapter.service.queue.BatchRequestQueueProviderService;
import nl.onlyonce.adapter.service.queue.CarerixRequestQueueProviderService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */

@Service
@Log
public class BatchRequestServiceImpl implements BatchRequestService {


    @Autowired
    CarerixRequestQueueProviderService carerixRequestQueueProviderService;

    @Autowired
    ZohoRequestQueueProviderService zohoRequestQueueProviderService;

    @Autowired
    BatchRequestQueueProviderService batchRequestQueueProviderService;

    @Override
    public void processRequest(final BatchRequestMessage message) {

        for (TargetType targetType : TargetType.values()) {
            switch (targetType) {
                case CARERIX:
                    for (CarerixRequestMessage carerixRequestMessage : message.getCarerixRequests()) {
                        carerixRequestQueueProviderService.addMessage(carerixRequestMessage);
                        // todo statusService.addMessage(carerixRequestMessage);
                    }
                    break;
                case ZOHO:
                    for (ZohoRequestMessage zohoRequestMessage : message.getZohoRequests()) {
                        zohoRequestQueueProviderService.addMessage(zohoRequestMessage);
                        // todo statusService.addMessage(carerixRequestMessage);

                    }
                    break;
                default:break;
            }
        }
    }

    @Override
    public void addMessage(BatchRequestMessage message) {
        batchRequestQueueProviderService.addMessage(message);
    }


}
