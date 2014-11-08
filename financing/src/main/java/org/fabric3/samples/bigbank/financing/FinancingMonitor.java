package org.fabric3.samples.bigbank.financing;

import org.fabric3.api.annotation.monitor.Info;

/**
 *
 */
public interface FinancingMonitor {

    @Info("Financing service invoked: {0}")
    void invoked(String id);
}
