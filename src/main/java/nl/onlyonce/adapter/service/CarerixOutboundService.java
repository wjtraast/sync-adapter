package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.Activity;

import java.util.List;

/**
 * @author: Gerben
 */
public interface CarerixOutboundService {

    List<Activity> prepareData(List<Activity> activities);

    void process(List<Activity> activities);
}
