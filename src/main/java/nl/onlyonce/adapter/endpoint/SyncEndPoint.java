package nl.onlyonce.adapter.endpoint;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.onlyonce.adapter.model.data.MessageType;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.message.ZohoRequestMessage;
import nl.onlyonce.adapter.service.SyncMessageStoreService;
import nl.onlyonce.adapter.service.batch.BatchRequestService;
import nl.onlyonce.adapter.service.queue.CarerixRequestQueueProviderService;
import nl.onlyonce.adapter.service.queue.ZohoRequestQueueProviderService;
import nl.onlyonce.adapter.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author: Gerben
 */
@RestController
public class SyncEndPoint {

    @Autowired
    BatchRequestService batchRequestService;

    @Autowired
    ZohoRequestQueueProviderService zohoRequestQueueProviderService;

    @Autowired
    SyncMessageStoreService syncMessageStoreService;

    @Autowired
    CarerixRequestQueueProviderService carerixRequestQueueProviderService;

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "/sync", nickname = "syncPost")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    String syncPost(@PathVariable String batchRequestMessage) {

        return null;
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    String testSync() {
        return "running";
    }


    @RequestMapping(value = "/sync-zoho", method = RequestMethod.POST)
    void syncZoho(@RequestBody ZohoRequestMessage message, HttpServletResponse response) throws Exception {

        message.setId(UUID.randomUUID().toString());

        validateMessage(message, response);
        syncMessageStoreService.save(message.getId(), MessageType.ZOHO_REQUEST_MESSAGE, JsonUtil.convertToString(message));
        zohoRequestQueueProviderService.addMessage(message);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @RequestMapping(value = "/sync-carerix", method = RequestMethod.POST)
    void syncCarerix(@RequestBody CarerixRequestMessage message, HttpServletResponse response) throws Exception {

        message.setId(UUID.randomUUID().toString());

        validateMessage(message, response);

        syncMessageStoreService.save(message.getId(), MessageType.CARERIX_REQUEST_MESSAGE, JsonUtil.convertToString(message));
        carerixRequestQueueProviderService.addMessage(message);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);

    }

    private void validateMessage(ZohoRequestMessage message, HttpServletResponse response) {
        if (message.validate()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    private void validateMessage(CarerixRequestMessage message, HttpServletResponse response) {
        if (message.validate()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }



    @RequestMapping(value = "/sync/carerix", method = RequestMethod.POST)
    void syncCarerix(@RequestBody CarerixRequestMessage message) {
        carerixRequestQueueProviderService.addMessage(message);
    }
//
//    @RequestMapping(value = "/sync/test/{targetString}", method = RequestMethod.GET)
//    String test(@PathVariable String targetString) {
//
//
//
//        TargetType targetType = TargetType.asTargetType(targetString.toUpperCase());
//
//        CarerixRequestMessage message = CarerixRequestMessage.builder().build();
//        List<CarerixRequestMessage> carerixRequestMessageList = new ArrayList<CarerixRequestMessage>();
//        carerixRequestMessageList.add(message);
//
//        BatchRequestMessage batchRequestMessage =
//                BatchRequestMessage.builder().carerixMessages(carerixRequestMessageList).build();
//
//        batchRequestService.addMessage(batchRequestMessage);
//        return "done";
//
//    }

}
