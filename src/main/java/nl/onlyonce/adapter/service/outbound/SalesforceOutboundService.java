package nl.onlyonce.adapter.service.outbound;

import nl.onlyonce.adapter.model.Activity;

import java.util.List;

/**
 * @author: Gerben
 */
public interface SalesforceOutboundService {

    void process(List<Activity> activities);


    List<Activity> prepareData(List<Activity> activities);
}
