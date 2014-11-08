package org.fabric3.samples.bigbank.payments;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.fabric3.api.annotation.Producer;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountsSystem;
import org.fabric3.samples.bigbank.api.backend.account.LedgerSystem;
import org.oasisopen.sca.annotation.Reference;

/**
 * Controller for payment resources.
 *
 * This controller is wired to legacy systems that expose WS-* (Web Services) APIs via {@code Reference} annotations.
 */
@EndpointUri("payments")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class PaymentController {

    @Monitor
    protected PaymentMonitor monitor;

    @Producer(target = "FraudChannel")
    protected FraudChannel fraudChannel;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/accountsSystem")
    protected AccountsSystem accountsSystem;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/ledgerSystem")
    protected LedgerSystem ledgerSystem;

    @Path("apply")
    @PUT
    public String transfer(String number) {
        monitor.invoked(number);
        fraudChannel.publish("test");
        return "OK";
    }

}
