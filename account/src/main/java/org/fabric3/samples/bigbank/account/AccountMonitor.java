package org.fabric3.samples.bigbank.account;

import org.fabric3.api.annotation.monitor.Info;

/**
 *
 */
public interface AccountMonitor {

    @Info("Account controller invoked: {0}")
    void invoked(String id);
}
