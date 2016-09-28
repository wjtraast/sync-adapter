package nl.onlyonce.adapter.service.api;

import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.TargetType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

/**
 * @author: Gerben
 */
@Service
public class OnlyOnceApiServiceImpl implements OnlyOnceApiService {

    @Override
    public List<Activity> getActivities(final TargetType type) {
        RestTemplate restTemplate = new RestTemplate();
       // Activity[] activityArray = restTemplate.getForObject("http://demo.onlyonce.nl/api/", Activity[].class);
        return Collections.EMPTY_LIST;
       // return Arrays.asList(activityArray);
    }
}
