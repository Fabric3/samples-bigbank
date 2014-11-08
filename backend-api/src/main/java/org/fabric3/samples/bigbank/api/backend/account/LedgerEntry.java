package org.fabric3.samples.bigbank.api.backend.account;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

/**
 * An entry in an account ledger.
 */
public class LedgerEntry {
    public static final int STATUS_PROCESSING = 0;
    public static final int STATUS_POSTED = 1;

    public static final int TYPE_DEBIT = 0;
    public static final int TYPE_CREDIT = 1;

    private int type;
    private int status;
    private String description;
    private BigDecimal amount;
    private XMLGregorianCalendar date;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
