package nl.onlyonce.adapter.service.target;

import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.message.SyncRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.api.OnlyOnceApiService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

                // TODO

            }


        }





    }

    private ZohoRequestMessage buildZohoRequesMessage(JSONObject object) {

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


        ZohoRequestMessage message = new ZohoRequestMessage();






        return message;
    }


}
