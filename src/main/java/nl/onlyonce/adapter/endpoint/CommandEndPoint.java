package nl.onlyonce.adapter.endpoint;


import lombok.extern.java.Log;
import nl.onlyonce.adapter.model.AdapterCommand;
import nl.onlyonce.adapter.model.AdapterCommandMessage;
import nl.onlyonce.adapter.model.type.AdapterType;
import nl.onlyonce.adapter.service.queue.AdapterCommandQueueProviderService;
import nl.onlyonce.adapter.system.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


/**
 * @author: Gerben
 */

@RestController
@Log
public class CommandEndPoint {

    @Autowired
    AdapterCommandQueueProviderService adapterCommandQueueProviderService;

    @Autowired
    Configuration configuration;

    @RequestMapping("/command/{commandString}")
    void process(@PathVariable String commandString, HttpServletResponse response) throws Exception {


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
        AdapterCommandMessage message = AdapterCommandMessage.builder()
                .id(UUID.randomUUID().toString())
                .adapterCommand(command)
                .adapterType(type).build();
        adapterCommandQueueProviderService.addMessage(message);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.getWriter().write(message.getId());
        response.getWriter().flush();
        response.getWriter().close();

    }

}