package org.fabric3.samples.bigbank.api.backend.account;

import org.oasisopen.sca.annotation.OneWay;

/**
 *
 */
public interface FinanceSystemCallback {

    @OneWay
    void reply(String app);
}
