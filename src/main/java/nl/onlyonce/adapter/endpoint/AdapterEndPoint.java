package nl.onlyonce.adapter.endpoint;


import nl.onlyonce.adapter.model.AdapterCommand;
import nl.onlyonce.adapter.model.AdapterCommandMessage;
import nl.onlyonce.adapter.model.type.AdapterType;
import nl.onlyonce.adapter.service.AdapterCommandQueueProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * @author: Gerben
 */

@RestController
public class AdapterEndPoint {

    @Autowired
    AdapterCommandQueueProviderService adapterCommandQueueProviderService;

    @RequestMapping("/command/{commandString}")
    void process(@PathVariable String commandString, HttpServletResponse response) {


        if (StringUtils.isEmpty(commandString)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        AdapterCommand command = AdapterCommand.asAdapterComand(commandString.toUpperCase());
        if (command == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        AdapterType type = AdapterType.CARERIX; // read from environment
        AdapterCommandMessage message = AdapterCommandMessage.builder().adapterCommand(command).adapterType(type).build();
        adapterCommandQueueProviderService.addMessage(message);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }


}