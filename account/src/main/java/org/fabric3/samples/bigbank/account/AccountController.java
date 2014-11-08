package org.fabric3.samples.bigbank.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountLedger;
import org.fabric3.samples.bigbank.api.backend.account.AccountsSystem;
import org.fabric3.samples.bigbank.api.backend.account.InternalAccountData;
import org.fabric3.samples.bigbank.api.backend.account.LedgerSystem;
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

    @Monitor
    protected AccountMonitor monitor;

    // injects a wire to the backend legacy accounts system which exposes a WS-* (Web Services) API
    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/accountsSystem")
    protected AccountsSystem accountsSystem;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/ledgerSystem")
    protected LedgerSystem ledgerSystem;

    @Path("{accountNumber}")
    @GET
    public Account getAccount(@PathParam("accountNumber") String number) {
        monitor.invoked(number);

        InternalAccountData internalData = accountsSystem.getAccountData(number);
        AccountLedger accountLedger = ledgerSystem.getLedger(number);

        return new Account(number, 100000, 10000);
    }

}
