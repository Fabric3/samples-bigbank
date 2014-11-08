package org.fabric3.samples.bigbank.financing;

import org.fabric3.samples.bigbank.api.backend.loan.LoanRequest;

/**
 * Interface to the backend legacy loan system.
 */
public interface Gateway {

    /**
     * Submit a loan application.
     *
     * @param request the application
     */
    void apply(LoanRequest request);

}
