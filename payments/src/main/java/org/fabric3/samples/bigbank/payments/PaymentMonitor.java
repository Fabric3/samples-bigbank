package org.fabric3.samples.bigbank.payments;

import org.fabric3.api.annotation.monitor.Info;

/**
 *
 */
public interface PaymentMonitor {

    @Info("Payment controller invoked: {0}")
    void invoked(String id);
}
