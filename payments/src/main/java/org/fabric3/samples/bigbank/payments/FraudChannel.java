package org.fabric3.samples.bigbank.payments;

/**
 *
 */
public interface FraudChannel {

    void publish(String payment);
}
