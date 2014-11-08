package org.fabric3.samples.backend.loan;

import java.math.BigDecimal;

import org.fabric3.api.annotation.model.Component;
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

    @Callback
    protected LoanSystemCallback callback;

    public void apply(LoanRequest request) {
        LoanResponse response = new LoanResponse();
        response.setCustomerId(request.getCustomerId());
        response.setAmount(request.getAmount());
        response.setApproved(true);
        response.setRate(BigDecimal.valueOf(3.40).setScale(2, ROUND_DOWN));
        response.setTerm(30);

        callback.reply(response);
    }
}
