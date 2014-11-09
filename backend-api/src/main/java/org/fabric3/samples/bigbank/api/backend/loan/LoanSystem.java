package org.fabric3.samples.bigbank.api.backend.loan;

import org.oasisopen.sca.annotation.Callback;
import org.oasisopen.sca.annotation.OneWay;

/**
 * The backend legacy loan system.
 *
 * Asynchronously receives XML messages over a JMS queue and sends responses back via another queue.
 */
@Callback(LoanSystemCallback.class)
public interface LoanSystem {

    /**
     * Sends the loan request asynchronously (one-way messaging). Responses are sent using the callback {@link LoanSystemCallback}.
     *
     * @param request the loan request
     */
    @OneWay
    void apply(LoanRequest request);
}
