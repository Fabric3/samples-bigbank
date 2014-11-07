package org.fabric3.samples.bigbank.account;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 */
public class Account {
    @JsonProperty
    private String number;

    @JsonProperty
    private int balance;

    @JsonProperty
    private int safeToSpend;

    public Account(String number, int balance, int safeToSpend) {
        this.number = number;
        this.balance = balance;
        this.safeToSpend = safeToSpend;
    }

    public String getNumber() {
        return number;
    }

    /**
     * Returns the account balance in cents.
     *
     * @return the account balance in cents
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Returns the safe-to-spend amount in cents.
     *
     * @return the safe-to-spend amount in cents
     */
    public int getSafeToSpend() {
        return safeToSpend;
    }
}
