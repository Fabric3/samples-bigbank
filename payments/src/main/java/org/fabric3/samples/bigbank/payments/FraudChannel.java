package org.fabric3.samples.bigbank.payments;

/**
 * A typed fraud channel.
 */
public interface FraudChannel {

    /**
     * Publish payment data.
     *
     * @param payment payment data
     */
    void publish(String payment);
}
