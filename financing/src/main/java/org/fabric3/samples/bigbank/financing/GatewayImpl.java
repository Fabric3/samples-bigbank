package org.fabric3.samples.bigbank.financing;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.jms.annotation.JMS;
import org.fabric3.api.binding.jms.annotation.JMSConfiguration;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystem;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystemCallback;
import org.oasisopen.sca.annotation.ManagedTransaction;
import org.oasisopen.sca.annotation.Reference;
import org.oasisopen.sca.annotation.Service;

/**
 * Controller for financing resources.
 *
 * This controller is wired to legacy systems that listen on JMS Queues via {@code Reference} annotations. Since this component is transaction, message delivery
 * is guaranteed.
 */
@Composite
@Component
@ManagedTransaction
@Service({Gateway.class, LoanSystemCallback.class})
public class GatewayImpl implements Gateway, LoanSystemCallback {
    @Monitor
    protected LoanMonitor monitor;

    @Reference
    @JMS(value = @JMSConfiguration(destination = "ApplicationQueue"), callback = @JMSConfiguration(destination = "ApplicationQueueCallbackQueue"))
    protected LoanSystem loanSystem;

    @Path("apply")
    @PUT
    public String apply(String app) {
        loanSystem.apply(app);
        return "ok";
    }

    public void reply(String id) {
        monitor.notification(id);
    }
}
