package nl.onlyonce.adapter.endpoint;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: Gerben
 */
@RequestMapping("/sync")
public class SyncEndPoint {

    @RequestMapping(method = RequestMethod.POST)
    String sync(@PathVariable String batchRequestMessage) throws Exception {

        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    String sync() throws Exception {
        return "running";
    }

}
