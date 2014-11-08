package org.fabric3.samples.backend.account;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountLedger;
import org.fabric3.samples.bigbank.api.backend.account.LedgerEntry;
import org.fabric3.samples.bigbank.api.backend.account.LedgerSystem;
import org.oasisopen.sca.annotation.EagerInit;

/**
 * A web service simulating a backend legacy system.
 */
@Component
@Composite
@EagerInit
@WebService
@WebServiceBinding(uri = "ledgerSystem")
public class LedgerSystemImpl implements LedgerSystem {

    @WebMethod
    public AccountLedger getLedger(String id) {
        LedgerEntry entry1 = createLedgerEntry(100.50, 1);
        LedgerEntry entry2 = createLedgerEntry(4.20, 2);
        LedgerEntry entry3 = createLedgerEntry(100, 4);

        return new AccountLedger(new LedgerEntry[]{entry1, entry2, entry3});
    }

    private LedgerEntry createLedgerEntry(double amount, int days) {
        LedgerEntry ledgerEntry = new LedgerEntry();
        ledgerEntry.setAmount(BigDecimal.valueOf(amount));

        XMLGregorianCalendar date = createDate(days);
        ledgerEntry.setDate(date);
        return ledgerEntry;
    }

    private XMLGregorianCalendar createDate(int days) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(days));

        DatatypeFactory factory = null;
        try {
            factory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new AssertionError(e);
        }
        return factory.newXMLGregorianCalendar(date);
    }
}
