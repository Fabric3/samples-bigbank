package org.fabric3.samples.bigbank.payments;

import org.fabric3.api.annotation.monitor.Info;

/**
 * Monitor/logging interface for the payment controller.
 */
public interface PaymentMonitor {

    @Info("Payment received: {0}")
    void invoked(String id);
}
