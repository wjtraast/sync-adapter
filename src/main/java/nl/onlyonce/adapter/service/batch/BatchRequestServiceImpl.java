package nl.onlyonce.adapter.service.batch;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.BaseRequestMessage;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.model.type.TargetType;
import nl.onlyonce.adapter.service.queue.CarerixRequestQueueProviderService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void processRequest(final BatchRequestMessage message) {

        for (TargetType targetType : TargetType.values()) {
            List<BaseRequestMessage> messages = message.getRequests(targetType);
            switch (targetType) {
                case CARERIX:
                    for (BaseRequestMessage targetRequestMessage : messages)
                        carerixRequestQueueProviderService.addMessage((CarerixRequestMessage) targetRequestMessage);
                    break;
                case ZOHO:
                    for (BaseRequestMessage targetRequestMessage : messages)
                        zohoRequestQueueProviderService.addMessage((ZohoRequestMessage) targetRequestMessage);
                    break;
                default:break;
            }
        }
    }
}
