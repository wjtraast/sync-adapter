package nl.onlyonce.adapter.endpoint;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import nl.onlyonce.adapter.model.message.BatchRequestMessage;
import nl.onlyonce.adapter.model.message.CarerixRequestMessage;
import nl.onlyonce.adapter.model.type.TargetType;
import nl.onlyonce.adapter.service.batch.BatchRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Gerben
 */
@RestController
public class SyncEndPoint {

    @Autowired
    BatchRequestService batchRequestService;

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
    String syncGet() {
        return "running";
    }

    @RequestMapping(value = "/sync/test/{targetString}", method = RequestMethod.GET)
    String test(@PathVariable String targetString) {



        TargetType targetType = TargetType.asTargetType(targetString.toUpperCase());

        CarerixRequestMessage message = CarerixRequestMessage.builder().build();
        List<CarerixRequestMessage> carerixRequestMessageList = new ArrayList<CarerixRequestMessage>();
        carerixRequestMessageList.add(message);

        BatchRequestMessage batchRequestMessage =
                BatchRequestMessage.builder().carerixMessages(carerixRequestMessageList).build();

        batchRequestService.addMessage(batchRequestMessage);
        return "done";

    }

}
