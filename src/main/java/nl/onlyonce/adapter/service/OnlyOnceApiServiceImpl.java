package nl.onlyonce.adapter.service;

import nl.onlyonce.adapter.model.Activity;
import nl.onlyonce.adapter.model.type.AdapterType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Gerben
 */
@Service
public class OnlyOnceApiServiceImpl implements OnlyOnceApiService {


    @Resource
    RestTemplate restTemplate;


    @Override
    public List<Activity> getActivities(final AdapterType type) {
        Activity[] activityArray = restTemplate.getForObject("http://demo.onlyonce.nl/api/", Activity[].class);
        return Arrays.asList(activityArray);
    }
}
