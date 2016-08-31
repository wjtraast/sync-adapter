package nl.onlyonce.adapter.endpoint;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: Gerben
 */
//@RequestMapping("/sync")
@RestController
public class SyncEndPoint {

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "/sync", nickname = "syncPost")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 202, message = "Accepted"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    String syncPost(@PathVariable String batchRequestMessage) throws Exception {

        return null;
    }

    @RequestMapping(value = "/sync", method = RequestMethod.GET)
    String syncGet() throws Exception {
        return "running";
    }

}
