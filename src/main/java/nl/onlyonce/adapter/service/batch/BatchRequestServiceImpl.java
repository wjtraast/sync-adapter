package nl.onlyonce.adapter.service.batch;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.model.type.TargetType;
import nl.onlyonce.adapter.service.queue.CarerixRequestQueueProviderService;
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


    @Override
    public void processRequest(final BatchRequestMessage message) {


        for (TargetType targetType : TargetType.values()) {
            List<?> messages = message.getRequests(targetType);



        }






    }
}
