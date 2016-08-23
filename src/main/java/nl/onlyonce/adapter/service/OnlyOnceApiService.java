package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.type.AdapterType;

import java.util.List;

/**
 * @author: Gerben
 */
public interface OnlyOnceApiService {

     List<Activity> getActivityList(AdapterType type);

}
