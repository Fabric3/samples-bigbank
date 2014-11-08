package org.fabric3.samples.bigbank.financing;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.jms.annotation.JMS;
import org.fabric3.api.binding.jms.annotation.JMSConfiguration;
import org.fabric3.samples.bigbank.api.backend.loan.LoanRequest;
import org.fabric3.samples.bigbank.api.backend.loan.LoanResponse;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystem;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystemCallback;
import org.oasisopen.sca.annotation.ManagedTransaction;
import org.oasisopen.sca.annotation.Reference;
import org.oasisopen.sca.annotation.Service;

/**
 * Controller for financing resources.
 *
 * This controller is wired to a legacy system that listens on JMS Queues via {@code Reference} annotations. Since this component is transaction, message
 * delivery is guaranteed. It demonstrates how to perform transactional, asynchronous message delivery and receive callbacks with Fabric3.
 *
 * A message is sent over JMS by invoking {@link GatewayImpl#loanSystem} over the <code>ApplicationQueue</code> and responses are received from the
 * <code>ApplicationCallbackQueue</code> by the {@link GatewayImpl#reply(LoanResponse)} method. Messages are enqueued and dequeued within an XA transaction.
 */
@Composite
@Component
@ManagedTransaction
@Service({Gateway.class, LoanSystemCallback.class})
public class GatewayImpl implements Gateway, LoanSystemCallback {
    @Monitor
    protected LoanMonitor monitor;

    @Reference
    @JMS(value = @JMSConfiguration(destination = "ApplicationQueue"), callback = @JMSConfiguration(destination = "ApplicationCallbackQueue"))
    protected LoanSystem loanSystem;

    @Path("apply")
    @PUT
    public void apply(LoanRequest request) {
        loanSystem.apply(request);
    }

    public void reply(LoanResponse response) {
        monitor.notification(response.getCustomerId());
        // the customer can be notified via mobile push, email or another mechanism
    }
}
