package org.fabric3.samples.bigbank.api.backend.account;

/**
 * Interface to the backend ledger legacy system.
 */
public interface LedgerSystem {

    /**
     * Returns the account ledge for the given account id.
     *
     * @param id the account id
     * @return the ledger
     */
    AccountLedger getLedger(String id);
}
