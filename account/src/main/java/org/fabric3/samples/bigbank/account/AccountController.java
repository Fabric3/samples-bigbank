package org.fabric3.samples.bigbank.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.scope.Composite;

/**
 *
 */
@EndpointUri("/")
@Path("accounts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
public class AccountController {

    @Path("/{accountNumber}")
    public Account getAccount(@PathParam("accountNumber") String number) {
        return new Account(number, 100000, 10000);
    }

}
