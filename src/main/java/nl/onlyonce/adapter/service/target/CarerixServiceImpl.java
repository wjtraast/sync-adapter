package nl.onlyonce.adapter.service.target;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.service.api.CarerixApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Gerben
 */
@Service
@Log
public class CarerixServiceImpl implements CarerixService {

    @Autowired
    CarerixApiService apiService;

    @Override
    public void processMessage(CarerixRequestMessage message) {
        log.info("CarerixServiceImpl : processMessage CarerixRequestMessage");
        apiService.addEmployee();


    }
}
