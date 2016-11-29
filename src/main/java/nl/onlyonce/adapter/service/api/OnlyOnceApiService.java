package nl.onlyonce.adapter.service.api;

import org.json.simple.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * @author: Gerben
 */
public interface OnlyOnceApiService {

     List<JSONObject> getCards() throws Exception;


    JSONObject getCard(String profileId, String cardId, String token) throws Exception;

    Map<String,String> getResumes(List<String> ids) throws Exception;
}
