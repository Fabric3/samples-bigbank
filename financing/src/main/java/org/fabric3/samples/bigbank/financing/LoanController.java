package org.fabric3.samples.bigbank.financing;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.oasisopen.sca.annotation.Reference;

/**
 * Controller for loan resources.
 */
@EndpointUri("loan")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class LoanController {

    @Monitor
    protected LoanMonitor monitor;

    @Reference
    protected Gateway gateway;

    @Path("apply")
    @PUT
    public String apply(String app) {
        monitor.invoked(app);
        gateway.apply(app);
        return "ok";
    }

    public void reply(String app) {

    }
}
