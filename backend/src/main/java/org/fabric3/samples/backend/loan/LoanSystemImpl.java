package org.fabric3.samples.backend.loan;

import java.math.BigDecimal;

import org.fabric3.api.MonitorChannel;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.jms.annotation.JMS;
import org.fabric3.api.binding.jms.annotation.JMSConfiguration;
import org.fabric3.samples.bigbank.api.backend.loan.LoanRequest;
import org.fabric3.samples.bigbank.api.backend.loan.LoanResponse;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystem;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystemCallback;
import org.oasisopen.sca.annotation.Callback;
import org.oasisopen.sca.annotation.ManagedTransaction;
import static java.math.BigDecimal.ROUND_DOWN;

/**
 * A JMS consumer simulating a backend legacy ledger system.
 *
 * This service also demonstrates how to create a transactional JMS consumer that sends responses over a callback queue.
 */
@Component
@Composite
@ManagedTransaction
@JMS(value = @JMSConfiguration(destination = "ApplicationQueue"), callback = @JMSConfiguration(destination = "ApplicationCallbackQueue"))
public class LoanSystemImpl implements LoanSystem {

    @Monitor
    protected MonitorChannel monitor;

    @Callback
    protected LoanSystemCallback callback;  // injected by the runtime

    /**
     * Method that receives loan request messages from the ApplicationQueue destination.
     *
     * @param request the message
     */
    public void apply(LoanRequest request) {
        monitor.info("Loan system invoked");

        LoanResponse response = new LoanResponse();
        response.setCustomerId(request.getCustomerId());
        response.setAmount(request.getAmount());
        response.setApproved(true);
        response.setRate(BigDecimal.valueOf(3.40).setScale(2, ROUND_DOWN));
        response.setTerm(30);

        // send the response back via the ApplicationCallbackQueue destination
        callback.reply(response);
    }
}
