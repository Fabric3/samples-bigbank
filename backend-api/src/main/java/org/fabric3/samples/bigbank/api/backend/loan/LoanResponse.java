package org.fabric3.samples.bigbank.api.backend.loan;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * An internal loan application.
 */
@XmlRootElement
public class LoanResponse {
    private boolean approved;

    private String customerId;

    private BigDecimal amount;

    private int term;

    private BigDecimal rate;

    public LoanResponse() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
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

}
