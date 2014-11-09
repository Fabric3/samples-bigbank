package org.fabric3.samples.bigbank.payments;

/**
 * A typed fraud channel.
 */
public interface FraudChannel {

    /**
     * Publish payment data.
     *
     * @param data encoded payment data
     */
    void publish(byte[] data);
}
