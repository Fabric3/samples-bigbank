package org.fabric3.samples.backend.reconciliation;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.fabric3.api.MonitorChannel;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.reconciliation.ReconciliationSystem;
import org.fabric3.samples.bigbank.api.backend.reconciliation.Transfer;
import org.oasisopen.sca.annotation.EagerInit;

/**
 * A web service simulating a backend legacy reconciliation system.
 *
 * This service also demonstrates how to expose a Web Service (JAX-WS) endpoint with Fabric3.
 */
@Component
@Composite
@EagerInit
@WebService
@WebServiceBinding(uri = "reconciliationSystem")
public class ReconciliationSystemImpl implements ReconciliationSystem {
    @Monitor
    protected MonitorChannel monitor;

    @WebMethod
    public void postTransfer(Transfer transfer) {
        monitor.info("Transfer received: " + transfer.getCustomerAccount());
    }
}
