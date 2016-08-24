package nl.onlyonce.adapter.endpoint;


import lombok.extern.java.Log;
import nl.onlyonce.adapter.Configuration;
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
@Log
public class CommandEndpoint {

    @Autowired
    AdapterCommandQueueProviderService adapterCommandQueueProviderService;

    @Autowired
    Configuration configuration;

    @RequestMapping("/command/{commandString}")
    void process(@PathVariable String commandString, HttpServletResponse response) {


        if (StringUtils.isEmpty(commandString)) {
            log.info("command could not be determined");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        AdapterCommand command = AdapterCommand.asAdapterComand(commandString.toUpperCase());
        if (command == null) {
            log.info("command could not be determined");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

        AdapterType type = AdapterType.asAdapterType(configuration.getName());
        if (type == null) {
            log.info("adapter type could not be determined");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        AdapterCommandMessage message = AdapterCommandMessage.builder().adapterCommand(command).adapterType(type).build();
        adapterCommandQueueProviderService.addMessage(message);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }


}