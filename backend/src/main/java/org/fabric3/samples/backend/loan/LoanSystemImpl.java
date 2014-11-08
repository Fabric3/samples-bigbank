package org.fabric3.samples.backend.loan;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.jms.annotation.JMS;
import org.fabric3.api.binding.jms.annotation.JMSConfiguration;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystem;
import org.fabric3.samples.bigbank.api.backend.loan.LoanSystemCallback;
import org.oasisopen.sca.annotation.Callback;
import org.oasisopen.sca.annotation.ManagedTransaction;

/**
 *
 */
@Component
@Composite
@ManagedTransaction
@JMS(value = @JMSConfiguration(destination = "ApplicationQueue"), callback = @JMSConfiguration(destination = "ApplicationQueueCallbackQueue"))
public class LoanSystemImpl implements LoanSystem {

    @Callback
    protected LoanSystemCallback callback;

    public void apply(String app) {
        System.out.println("Received");
        callback.reply("123");
    }
}
