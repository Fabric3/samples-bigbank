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

    public String getPayeeAccount() {
        return payeeAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
