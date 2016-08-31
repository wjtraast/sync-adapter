package nl.onlyonce.adapter.service.api;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.Credentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Gerben
 */

@Service
@Log
public class CarerixApiServiceImpl implements CarerixApiService {

    @Autowired
    private final Credentials credentials;
    RestTemplate restTemplate;

    public CarerixApiServiceImpl() {

        credentials = Credentials.builder().username("Developer").password("9H7pNdDC").build();
    }


    @Override
    public void addEmployee() {

        restTemplate = new RestTemplate();
    }

    @Override
    public void getEmployee() {

    }

    @Override
    public void updateEmployee() {

    }
}
