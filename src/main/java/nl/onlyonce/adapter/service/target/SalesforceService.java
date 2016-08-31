package nl.onlyonce.adapter.service.target;

import nl.onlyonce.adapter.model.Activity;

import java.util.List;

/**
 * @author: Gerben
 */
public interface SalesforceService {

    void process(List<Activity> activities);


    List<Activity> prepareData(List<Activity> activities);
}
