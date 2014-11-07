package org.fabric3.samples.api.backend.account;

import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

/**
 *
 */
@XmlRootElement
public class InternalAccountData {
    private String number;
    private BigDecimal balance;

    public InternalAccountData(String number, BigDecimal balance) {
        this.number = number;
        this.balance = balance;
    }

    public InternalAccountData() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
