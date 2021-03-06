package org.fabric3.samples.bigbank.api.backend.reconciliation;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 * An transfer between two accounts.
 */
@XmlRootElement
public class Transfer {
    private String customerAccount;

    private String payeeAccount;

    private BigDecimal amount;

    private String description;

    public Transfer() {
    }

    public Transfer(String customerAccount, String payeeAccount, BigDecimal amount, String description) {
        this.customerAccount = customerAccount;
        this.payeeAccount = payeeAccount;
        this.amount = amount;
        this.description = description;
    }

    public String getCustomerAccount() {
        return customerAccount;
    }

    public void setCustomerAccount(String customerAccount) {
        this.customerAccount = customerAccount;
    }

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public void setPayeeAccount(String payeeAccount) {
        this.payeeAccount = payeeAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
