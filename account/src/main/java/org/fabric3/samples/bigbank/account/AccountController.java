package org.fabric3.samples.bigbank.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountsSystem;
import org.fabric3.samples.bigbank.api.backend.account.InternalAccountData;
import org.oasisopen.sca.annotation.Reference;

/**
 *
 */
@EndpointUri("accounts")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class AccountController {

    // injects a wire to the backend legacy accounts system which exposes a WS-* (Web Services) API
    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/accountsSystem")
    protected AccountsSystem accountsSystem;

    @Path("{accountNumber}")
    @GET
    public Account getAccount(@PathParam("accountNumber") String number) {
        InternalAccountData internalData = accountsSystem.getAccountData(number);

        return new Account(number, 100000, 10000);
    }

}
