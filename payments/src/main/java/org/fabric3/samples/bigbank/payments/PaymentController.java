package org.fabric3.samples.bigbank.payments;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;

import org.fabric3.api.annotation.Producer;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.reconciliation.ReconciliationSystem;
import org.fabric3.samples.bigbank.api.backend.reconciliation.Transfer;
import org.fabric3.samples.bigbank.api.services.payments.Payment;
import org.oasisopen.sca.annotation.Reference;
import static java.math.BigDecimal.ROUND_DOWN;

/**
 * Controller for payment resources.
 *
 * This controller is wired to legacy systems that expose WS-* (Web Services) APIs via {@code Reference} annotations. It is also connected to the fraud
 * detection channel where it publishes messages using high-performance messaging to consumers that perform fraud analysis.
 */
@EndpointUri("payments")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class PaymentController {
    private static final BigDecimal DIVISOR = BigDecimal.valueOf(100);

    @Monitor
    protected PaymentMonitor monitor;

    @Producer(target = "FraudChannel")
    protected FraudChannel fraudChannel;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/reconciliationSystem")
    protected ReconciliationSystem reconciliationSystem;

    @PUT
    public Response transfer(Payment payment) {
        monitor.invoked(payment.getCustomerAccount());

        fraudChannel.publish(encodeFraudData(payment)); // send the fraud data

        Transfer transfer = createTransfer(payment);

        reconciliationSystem.postTransfer(transfer);
        return Response.status(Response.Status.CREATED).build();
    }

    private Transfer createTransfer(Payment payment) {
        BigDecimal amount = BigDecimal.valueOf(payment.getAmount()).setScale(2, ROUND_DOWN).divide(DIVISOR, ROUND_DOWN);
        return new Transfer(payment.getCustomerAccount(), payment.getPayeeAccount(), amount, payment.getDescription());
    }

    /**
     * Function to simulate encoding of fraud data for high-performance messaging. In an actual system, a serialization technology such as Protobufs or SBE
     * could be used.
     *
     * @param payment the payment data
     * @return the encoded data
     */
    private byte[] encodeFraudData(Payment payment) {
        return payment.getCustomerAccount().getBytes();
    }

}
