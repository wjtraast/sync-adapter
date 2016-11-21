package nl.onlyonce.adapter.service.api;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Gerben
 */
@Service
public class OnlyOnceApiServiceImpl implements OnlyOnceApiService {


    final String endPoint = "https://apibeta.onlyonce.com";  // @ TODO via properties file
    final String secretKey = "OPklop90()!";

    /*

    1.       For list all card use /profiles/{your profile id}/cards?scope=ACCEPTED Then you’ll get all cards that were shared with you.

2.       Filter response data on your side by field "predefinedType".

3.       Call /profiles/{your profile id}/access with Secret-Key header

4.       Then use /profiles/{your profile id}/cards/{id of card from step two}



    http://ooapidocs.herokuapp.com/all
    https://apibeta.onlyonce.com

    1. Api call naar OO via PAW uitwerken
    2. APi call naar OO in java
    3. berichten samenstellen voor Zoho
    4. Properties file gebruiken
    5. Deployment op server


     */

    @Override
    public List<JSONObject> getCards() throws Exception {

        String token = getAuthToken();
        String profileId = getMyProfileId(token);
        JSONObject cards = getAcceptedCards(profileId, token);
        JSONArray cardsArray = (JSONArray) cards.get("content");

        List<String> ids = new ArrayList<>();
        for (int i = 0; i < cardsArray.size(); i++) {
            Map objectMap = (Map) cardsArray.get(i);
            String dataType = (String) objectMap.get("predefinedType") ;
            if ("PERSONAL_FLEXWORKER".equalsIgnoreCase(dataType)) {
                ids.add((String) objectMap.get("id"));
            }
        }

        List<JSONObject> personalCards = new ArrayList<>();
        getAccess(profileId, token, secretKey);
        for (String cardId : ids) {
            JSONObject personalCard = getCard(profileId, cardId, token);
            personalCards.add(personalCard);
        }

        return personalCards;

   }

    @Override
    public JSONObject getCard(String profileId, String cardId, String token) throws Exception {
        String card = getRequest(OnlyOnceApiConfiguration.Endpoints.PROFILES + "/" + profileId + "/cards/" + cardId, token);
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(card);
        return obj;

    }

    private void getAccess(String id, String token, String secretKey) throws Exception {
        Response result = Request.Post(OnlyOnceApiConfiguration.DOMAIN + OnlyOnceApiConfiguration.Endpoints.PROFILES + "/" + id + "/access")
                .addHeader("Secret-Key", secretKey)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .execute();
      //  return result.returnResponse().getHeaders("Authorization")[0].getValue();
    }

    private JSONObject getAcceptedCards(String id, String token) throws Exception {

        String cards = getRequest(OnlyOnceApiConfiguration.Endpoints.PROFILES + "/" + id + "/cards?scope=ACCEPTED", token);
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(cards);
        return obj;

    }

    private String getMyProfileId(String token) throws Exception {
        String profileResult = getRequest(OnlyOnceApiConfiguration.Endpoints.PROFILES + "?scope=MINE&page=0&size=100", token);
        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(profileResult);
        JSONArray content = (JSONArray) obj.get("content");
        JSONObject profile = (JSONObject) content.get(0);
        return (String) profile.get("id");
    }


    private String getAuthToken() throws Exception {

        JSONObject obj = new JSONObject();
        obj.put("username", "wjtraast@gmail.com");
        obj.put("password", "OPklop90()!");
        obj.toJSONString();

        String authToken = Request.Post(OnlyOnceApiConfiguration.DOMAIN + OnlyOnceApiConfiguration.Endpoints.SIGNIN)
                .addHeader("Content-Type", "application/json")
                .bodyString(obj.toJSONString(), ContentType.DEFAULT_TEXT)
                .execute().returnResponse().getHeaders("Authorization")[0].getValue();
        return authToken;

    }

    private String getRequest(String endPoint, String token) throws Exception {
        String result = Request.Get(OnlyOnceApiConfiguration.DOMAIN + endPoint)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().toString();
        return result;
    }



}
