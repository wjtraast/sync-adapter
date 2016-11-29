package nl.onlyonce.adapter.service.api;

import nl.onlyonce.adapter.ApplicationProperties;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author: Gerben
 */
@Service
public class OnlyOnceApiServiceImpl implements OnlyOnceApiService {


    @Autowired
    ApplicationProperties applicationConfiguration;

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
        getAccess(profileId, token, applicationConfiguration.getOnlyonceApiSecretKey());
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

    @Override
    public Map<String, String> getResumes(List<String> ids) throws Exception {
       //  /profiles/{profileId}/files/{fileMetadataId}/download[GET]

        Map<String, String> returnMap = new HashMap<>();

        String token = getAuthToken();
        String profileId = getMyProfileId(token);
        getAccess(profileId, token, applicationConfiguration.getOnlyonceApiSecretKey());
        for (String id : ids) {
            byte[] content = getRequestWithByteArray(OnlyOnceApiConfiguration.Endpoints.PROFILES + "/" + profileId + "/files/" + id + "/download", token);
            String encoded = Base64.getEncoder().encodeToString(content);
            returnMap.put(id, encoded);
        }

        return returnMap;


    }

    private void getAccess(String id, String token, String secretKey) throws Exception {
        Response result = Request.Post(applicationConfiguration.getOnlyOnceApiUrl() + OnlyOnceApiConfiguration.Endpoints.PROFILES + "/" + id + "/access")
                .addHeader("Secret-Key", secretKey)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .execute();
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
        obj.put("username", applicationConfiguration.getOnlyOnceApiUsername());
        obj.put("password", applicationConfiguration.getOnlyOnceApiPassword());
        obj.toJSONString();

        HttpResponse response = Request.Post(applicationConfiguration.getOnlyOnceApiUrl()  + OnlyOnceApiConfiguration.Endpoints.SIGNIN)
                .addHeader("Content-Type", "application/json")
                .bodyString(obj.toJSONString(), ContentType.DEFAULT_TEXT)
                .execute().returnResponse();

        Header[] headers = response.getHeaders("Authorization");
        String authToken = headers[0].getValue();

        return authToken;

    }

    private String getRequest(String endPoint, String token) throws Exception {
        String result = Request.Get(applicationConfiguration.getOnlyOnceApiUrl()  + endPoint)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .execute().returnContent().toString();
        return result;
    }

    private byte[] getRequestWithByteArray(String endPoint, String token) throws Exception {
        HttpEntity result = Request.Get(applicationConfiguration.getOnlyOnceApiUrl()  + endPoint)
                .addHeader("Authorization", token)
                .addHeader("Content-Type", "application/json")
                .execute().returnResponse().getEntity();
        return EntityUtils.toByteArray(result);
    }



}
