package org.fabric3.samples.bigbank.api.backend.account;

import org.oasisopen.sca.annotation.Callback;
import org.oasisopen.sca.annotation.OneWay;

/**
 *
 */
@Callback(FinanceSystemCallback.class)
public interface FinanceSystem {

    @OneWay
    void apply(String app);
}
