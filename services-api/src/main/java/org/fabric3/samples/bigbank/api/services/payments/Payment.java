package org.fabric3.samples.bigbank.api.services.payments;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A payment.
 */
public class Payment {
    @JsonProperty
    private String customerAccount;

    @JsonProperty
    private String payeeAccount;

    @JsonProperty
    private int amount;

    @JsonProperty
    private String description;

    public Payment() {
    }

    public Payment(String customerAccount, String payeeAccount, int amount, String description) {
        this.customerAccount = customerAccount;
        this.payeeAccount = payeeAccount;
        this.amount = amount;
        this.description = description;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
