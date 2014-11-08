package org.fabric3.samples.bigbank.api.backend.loan;

import org.oasisopen.sca.annotation.OneWay;

/**
 * A response receiver for asynchronous messages from the legacy backend loan system. Responses are XML messages sent over a JMS queue.
 */
public interface LoanSystemCallback {

    @OneWay
    void reply(LoanResponse response);
}
