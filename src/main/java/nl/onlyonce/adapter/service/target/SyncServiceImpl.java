package nl.onlyonce.adapter.service.target;

import com.jayway.jsonpath.JsonPath;
import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ResumeWrapper;
import nl.onlyonce.adapter.model.message.SyncRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.api.OnlyOnceApiService;
import nl.onlyonce.adapter.service.queue.CarerixRequestQueueProviderService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Autowired
    CarerixRequestQueueProviderService carerixRequestQueueProviderService;




    @Override
    public void processMessage(SyncRequestMessage message) {

        if (message.syncZoho) {

            try {
                List<ZohoRequestMessage> messages = new ArrayList<>();
                List<JSONObject> cards = onlyOnceApiService.getCards();
                for (JSONObject card : cards)  {

                    ZohoRequestMessage zohoRequestMessage = buildZohoRequesMessage(card);
                    List<ResumeWrapper> resumes = getResumes(card);
                    zohoRequestMessage.setResumes(resumes);
                    messages.add(zohoRequestMessage);
                }



                for (ZohoRequestMessage zohoRequestMessage : messages) {
                    zohoRequestQueueProviderService.addMessage(zohoRequestMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();

            }
        } else if (message.syncCarerix) {

            try {
                List<CarerixRequestMessage> messages = new ArrayList<>();
                List<JSONObject> cards = onlyOnceApiService.getCards();
                for (JSONObject card : cards)  {

                    CarerixRequestMessage carerixRequestMessage = buildCarerixRequestMessage(card);
                    List<ResumeWrapper> resumes = getResumes(card);
                    carerixRequestMessage.setResumes(resumes);
                    messages.add(carerixRequestMessage);
                }

                for (CarerixRequestMessage zohoRequestMessage : messages) {
                    carerixRequestQueueProviderService.addMessage(zohoRequestMessage);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private List<ResumeWrapper> getResumes(final JSONObject card) throws Exception {

        List<ResumeWrapper> returnValue = new ArrayList<>();
        net.minidev.json.JSONArray fileMetaDatas = (net.minidev.json.JSONArray) JsonPath.parse(card.toString()).read("$..fileMetaData", Object.class);
        if (fileMetaDatas != null) {
            List<String> ids = new ArrayList<>();
            for (int i = 0; i < fileMetaDatas.size(); i++) {
                Map fileMetaData = (Map) fileMetaDatas.get(i);
                String id = (String) fileMetaData.get("id");
                ids.add(id);
            }

            Map<String, String> documentMap = onlyOnceApiService.getResumes(ids);
            for (int i = 0; i < fileMetaDatas.size(); i++) {
                Map fileMetaData = (Map) fileMetaDatas.get(i);
                String id = (String) fileMetaData.get("id");

                String fileName = (String) fileMetaData.get("name");
                ResumeWrapper wrapper = new ResumeWrapper();
                wrapper.setFilename(fileName);
                wrapper.setId(id);
                String content = documentMap.get(id);
                wrapper.setFileContent(content);
                returnValue.add(wrapper);
            }
        }
        return returnValue;
    }


    private CarerixRequestMessage buildCarerixRequestMessage(JSONObject card) {

        /*
        {
  "cardname": "My FlexWorker Card",
  "cardId":"341A46D2-AAC4-458F-AF97-D62AFA4A0945",
  "firstname": "John",
  "lastname": "Visser05",
  "initials": "J J",
  "email1": "someemail@asdfasdfasdf.nl",
  "landline1": "0204444444",
  "mobile1": "065555555",
  "streetname1": "Street",
  "houseNumber": "122",
  "city": "SomeCity",
  "dateOfBirth": "18-12-1970",
  "postalCode": "9999BB",
  "availableFromDate":"17-12-2016",
  "gender":"Male",
  "currentSalary":"150.13",
  "note1":"asdfadf",
  "note2":"sdfasdfasdf",
  "jobTitle":"Software engineer yeah",
   "resumes":[
   {"filename":"1111.txt","file-content":"dGVzdCBpZXRz"},
   {"filename":"2222.txt","file-content":"dGVzdCBpZXRz"},
   {"filename":"3333.txt","file-content":"dGVzdCBpZXRz"}]
}
         */

        Map cardMap = updateCardFields(card);

        CarerixRequestMessage message = new CarerixRequestMessage();

        message.setGender((String) cardMap.get("gender_field"));
        message.setFirstname((String) cardMap.get("first_name_field"));
        message.setLastname((String) cardMap.get("last_name_field"));
        message.setInitials((String) cardMap.get("initials_field"));
        message.setDateOfBirth((String) cardMap.get("date_of_birth_field"));

        message.setStreetname1((String) cardMap.get("street_name_field"));
        message.setPostalCode((String) cardMap.get("postal_code_field"));
        message.setCity((String) cardMap.get("city_field"));
      //  message.setJobTitle();
        message.setAvailableFromDate((String) cardMap.get("flex_availability_from_field"));

        message.setMobile1((String) cardMap.get("communication_mobtel1_field"));
        message.setLandline1((String) cardMap.get("communication_landline1_field"));
        message.setEmail1((String) cardMap.get("communication_email1_field"));

        message.setCardId((String) card.get("id"));


        return message;

    }

    private ZohoRequestMessage buildZohoRequesMessage(JSONObject card) {

        Map cardMap = updateCardFields(card);


        ZohoRequestMessage message = new ZohoRequestMessage();
        message.setType("pds");

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

    private Map updateCardFields(Map card) {
        Map<String, String> cardFieldMap = populateCardMap();
        Map cardMap = card;


        JSONArray model = (JSONArray) cardMap.get("model");
        JSONObject personalDataStore = (JSONObject) model.get(0);
        JSONArray pdsComponents = (JSONArray) personalDataStore.get("components");

        /*
        Hier moet nog ergens de attachment uit card worden gehaald en in het bericht worden gestop.
         */


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
        return cardMap;
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
