package nl.onlyonce.adapter.service.api;

import org.json.simple.JSONObject;

import java.util.List;

/**
 * @author: Gerben
 */
public interface OnlyOnceApiService {

     List<JSONObject> getCards() throws Exception;


    JSONObject getCard(String profileId, String cardId, String token) throws Exception;
}
