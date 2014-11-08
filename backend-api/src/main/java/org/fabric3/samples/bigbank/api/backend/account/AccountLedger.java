package org.fabric3.samples.bigbank.api.backend.account;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JAXB data structure that represents an account ledger.
 */
@XmlRootElement
public class AccountLedger {
    private LedgerEntry[] entries;

    public AccountLedger() {
    }

    public AccountLedger(LedgerEntry[] entries) {
        this.entries = entries;
    }

    public LedgerEntry[] getEntries() {
        return entries;
    }

    public void setEntries(LedgerEntry[] entries) {
        this.entries = entries;
    }
}
