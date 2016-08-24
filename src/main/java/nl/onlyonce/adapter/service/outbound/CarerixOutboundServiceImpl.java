package nl.onlyonce.adapter.service.outbound;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.Activity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * @author: Gerben
 */
@Service
@Log
public class CarerixOutboundServiceImpl implements CarerixOutboundService {


    @Override
    public List<Activity> prepareData(List<Activity> activities) {
        return Collections.EMPTY_LIST;
    }

    @Override
    public void process(List<Activity> activities) {

        log.info("process carerix outbound");

    }
}
