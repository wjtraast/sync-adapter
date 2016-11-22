package nl.onlyonce.adapter.service.target;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.SyncRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.api.OnlyOnceApiService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Gerben
 */

@Service
@Log
public class SyncServiceImpl implements SyncService {

    @Autowired
    private OnlyOnceApiService onlyOnceApiService;

    @Autowired
    ZohoRequestQueueProviderService zohoRequestQueueProviderService;



    @Override
    public void processMessage(SyncRequestMessage message) {

        List<ZohoRequestMessage> zohoRequestMessageList = new ArrayList<>();

        if (message.syncZoho) {

            try {
                List<ZohoRequestMessage> messages = new ArrayList<>();
                List<JSONObject> cards = onlyOnceApiService.getCards();
                for (JSONObject object : cards)  {

                    ZohoRequestMessage zohoRequestMessage = buildZohoRequesMessage(object);
                    messages.add(zohoRequestMessage);
                }

                for (ZohoRequestMessage zohoRequestMessage : messages) {
                    zohoRequestQueueProviderService.addMessage(zohoRequestMessage);
                }


            } catch (Exception e) {

                e.printStackTrace();

            }


        }
    }

    private ZohoRequestMessage buildZohoRequesMessage(JSONObject card) {

        Map<String, String> cardFieldMap = populateCardMap();
        Map cardMap = (Map) card;

        ZohoRequestMessage message = new ZohoRequestMessage();
        message.setType("pds");

        JSONArray model = (JSONArray) cardMap.get("model");
        JSONObject personalDataStore = (JSONObject) model.get(0);
        JSONArray pdsComponents = (JSONArray) personalDataStore.get("components");

        for (int i =0; i < pdsComponents.size() ; i ++) {
            JSONObject pdfComponent = (JSONObject) pdsComponents.get(i);


            if (pdfComponent.get("definitionName").equals("personal_information_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("personal_information_details_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("jobs_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("flex_workers_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("addresses_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("communication_channels_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("web_presence_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            } else if (pdfComponent.get("definitionName").equals("meta_data_group")) {
                updateCardField(cardFieldMap, cardMap, pdfComponent);

            }
        }

        message.setGender((String) cardMap.get("gender_field"));
        message.setFirstname((String) cardMap.get("first_name_field"));
        message.setLastname((String) cardMap.get("last_name_field"));
        message.setInitials((String) cardMap.get("initials_field"));
        message.setDateOfBirth((String) cardMap.get("date_of_birth_field"));

        message.setStreetname1((String) cardMap.get("street_name_field"));
        message.setPostalCode((String) cardMap.get("postal_code_field"));
        message.setRegion((String) cardMap.get("region_field"));
        message.setCity((String) cardMap.get("city_field"));
        message.setCountry((String) cardMap.get("country_field"));

        message.setAcademicTitle((String) cardMap.get("academic_title_field"));
        message.setJobPosition((String) cardMap.get("job_position_field"));
        message.setFlexAvailabilityFrom((String) cardMap.get("flex_availability_from_field"));
        message.setFlexAvailabilityTo((String) cardMap.get("flex_availability_to_field"));
//        message.setCustomFields((String) cardMap.get("hours_per_week_field"));
        message.setHourlyRate((String) cardMap.get("indicative_hourly_rate_field"));
        message.setMinHourRate((String) cardMap.get("minimum_hourly_rate_field"));
        message.setSkills((String) cardMap.get("skills_field"));

        message.setMobile1((String) cardMap.get("communication_mobtel1_field"));
        message.setMobile2((String) cardMap.get("communication_mobtel2_field"));
        message.setMobile3((String) cardMap.get("communication_mobtel3_field"));
        message.setLandline1((String) cardMap.get("communication_landline1_field"));
        message.setLandline2((String) cardMap.get("communication_landline2_field"));
        message.setLandline3((String) cardMap.get("communication_landline3_field"));
        message.setEmail1((String) cardMap.get("communication_email1_field"));
        message.setEmail2((String) cardMap.get("communication_email2_field"));
        message.setSkypeId((String) cardMap.get("communication_skype_field"));

        message.setLinkedin((String) cardMap.get("primary_linkedin_field"));
        message.setWebsite((String) cardMap.get("primary_website_field"));


        message.setCardId((String) card.get("id"));

        return message;

            /*
            group personal_info
            group personal_info_details
            group jobs
            group flex_worker_data
            group addresses
            group communication_channels
            group web_presence
            group meta_data
             */
    }

    private void updateCardField(Map<String, String> cardFieldMap, Map cardMap, JSONObject pdsComponent) {
        JSONArray groupComps = (JSONArray) pdsComponent.get("components");
        for (int i = 0; i < groupComps.size(); i ++) {
            for (String key : cardFieldMap.keySet()) {
                JSONObject groupComp = (JSONObject) groupComps.get(i);
                if (groupComp.get("definitionName").equals(key)) {
                    String value = (String) groupComp.get("value");
                    cardMap.put(key, value);
                }
            }
        }
    }

    private Map<String, String> populateCardMap() {
        Map<String, String> cardMap = new HashMap<>();

        cardMap.put("gender_field", null);
        cardMap.put("first_name_field", null);
        cardMap.put("middle_name_field", null);
        cardMap.put("last_name_field", null);
        cardMap.put("initials_field", null);
        cardMap.put("date_of_birth_field", null);

        cardMap.put("street_name_field", null);
        cardMap.put("postal_code_field", null);
        cardMap.put("region_field", null);
        cardMap.put("city_field", null);
        cardMap.put("country_field", null);

        cardMap.put("academic_title_field", null);
        cardMap.put("job_position_field", null);

        cardMap.put("flex_availability_from_field", null);
        cardMap.put("flex_availability_to_field", null);
        cardMap.put("hours_per_week_field", null);
        cardMap.put("indicative_hourly_rate_field", null);
        cardMap.put("minimum_hourly_rate_field", null);
        cardMap.put("skills_field", null);

        cardMap.put("communication_mobtel1_field", null);
        cardMap.put("communication_mobtel2_field", null);
        cardMap.put("communication_mobtel3_field", null);
        cardMap.put("communication_landline1_field", null);
        cardMap.put("communication_landline2_field", null);
        cardMap.put("communication_landline3_field", null);
        cardMap.put("communication_email1_field", null);
        cardMap.put("communication_email2_field", null);
        cardMap.put("communication_skype_field", null);

        cardMap.put("primary_linkedin_field", null);
        cardMap.put("primary_website_field", null);

        return cardMap;
    }

        /*

         "type": "pds",
  "cardname": "My Card name",
  "firstname": "Piet",
  "lastname": "Jansen Traaster",
  "initials": "J J",
  "salutation": "De heer",
  "dateOfBirth": "02/20/1930",
  "academicTitle": "Ing",
  "academicSuffix": "Bsc",
  "email1": "test@test12.nl",
  "email2": "test2@test2.nl",
  "mobile1": "0611111111",
  "landline1": "0201111111",
  "landline2": "0202222222",
  "landline3": "0203333333",
  "skypeId": "tester",
  "twitter": "@tester",
  "streetname1": "Kerkstraat",
  "streetname2": "deel 2",
  "houseNumber": "11a",
  "city": "Amsterdam",
  "region": "Noord Holland",
  "country": "Nederland",
  "postalCode": "1101AA",
  "linkOds":"-1"

         */
}
