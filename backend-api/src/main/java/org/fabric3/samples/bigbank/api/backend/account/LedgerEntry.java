package org.fabric3.samples.bigbank.api.backend.account;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

/**
 *
 */
public class LedgerEntry {
    private int type;
    private String description;
    private BigDecimal amount;
    private XMLGregorianCalendar date;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }
}
