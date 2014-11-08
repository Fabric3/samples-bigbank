package org.fabric3.samples.bigbank.api.backend.reconciliation;

/**
 * The backend legacy reconciliation system.
 */
public interface ReconciliationSystem {

    /**
     * Posts a transfer between two accounts.
     *
     * @param transfer the transfer
     */
    void postTransfer(Transfer transfer);
}
