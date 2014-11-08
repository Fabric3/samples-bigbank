package org.fabric3.samples.bigbank.api.backend.loan;

import org.oasisopen.sca.annotation.OneWay;

/**
 *
 */
public interface LoanSystemCallback {

    @OneWay
    void reply(String app);
}
