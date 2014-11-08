package org.fabric3.samples.bigbank.api.backend.loan;

import org.oasisopen.sca.annotation.Callback;
import org.oasisopen.sca.annotation.OneWay;

/**
 *
 */
@Callback(LoanSystemCallback.class)
public interface LoanSystem {

    @OneWay
    void apply(String app);
}
