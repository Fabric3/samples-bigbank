package org.fabric3.samples.bigbank.api.services.financing;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A loan application.
 */
public class LoanApplication {
    @JsonProperty
    private String customerId;

    @JsonProperty
    private String merchantId;

    @JsonProperty
    private int amount;

    @JsonProperty
    private int term;


    public LoanApplication() {
    }

    public LoanApplication(String customerId, String merchantId, int amount, int term) {
        this.customerId = customerId;
        this.merchantId = merchantId;
        this.amount = amount;
        this.term = term;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public int getAmount() {
        return amount;
    }

    public int getTerm() {
        return term;
    }
}
