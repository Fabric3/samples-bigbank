package org.fabric3.samples.bigbank.financing;

import org.fabric3.api.annotation.monitor.Info;

/**
 * Monitor/logging interface for the loan controller.
 */
public interface LoanMonitor {

    @Info("Loan application received: {0}")
    void invoked(String id);

    @Info("Notification sent: {0}")
    void notification(String id);

}
