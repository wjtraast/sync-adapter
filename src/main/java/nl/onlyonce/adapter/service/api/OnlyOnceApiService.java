package nl.onlyonce.adapter.service.api;

import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.TargetType;

import java.util.List;

/**
 * @author: Gerben
 */
public interface OnlyOnceApiService {

     List<Activity> getActivities(TargetType type);

}
