package org.fabric3.samples.bigbank.api.backend.account;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * JAXB data structure that represents an account ledger.
 */
@XmlRootElement
public class AccountLedger {
    private LedgerEntry[] ledgerEntries;

    public AccountLedger() {
    }

    public AccountLedger(LedgerEntry[] ledgerEntries) {
        this.ledgerEntries = ledgerEntries;
    }

    public LedgerEntry[] getLedgerEntries() {
        return ledgerEntries;
    }

    public void setLedgerEntries(LedgerEntry[] ledgerEntries) {
        this.ledgerEntries = ledgerEntries;
    }
}
