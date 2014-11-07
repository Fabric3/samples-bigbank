package org.fabric3.samples.bigbank.api.backend.account;

/**
 * Interface to the backend legacy system.
 */
public interface AccountsSystem {

    /**
     * Returns account information in a legacy format.
     *
     * @param id the account id.
     * @return the account data
     */
    InternalAccountData getAccountData(String id);
}
