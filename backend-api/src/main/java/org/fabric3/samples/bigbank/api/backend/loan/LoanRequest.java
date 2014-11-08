package org.fabric3.samples.bigbank.api.backend.loan;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * An internal loan application.
 */
@XmlRootElement
public class LoanRequest {
    private String customerId;

    private String merchantId;

    private BigDecimal amount;

    private int term;

    private String division;

    public LoanRequest() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
