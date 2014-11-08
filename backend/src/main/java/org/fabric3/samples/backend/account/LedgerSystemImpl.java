package org.fabric3.samples.backend.account;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.fabric3.api.MonitorChannel;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountLedger;
import org.fabric3.samples.bigbank.api.backend.account.LedgerEntry;
import org.fabric3.samples.bigbank.api.backend.account.LedgerSystem;
import org.oasisopen.sca.annotation.EagerInit;
import org.oasisopen.sca.annotation.Init;

/**
 * A web service simulating a backend legacy ledger system.
 *
 * This service also demonstrates how to expose a Web Service (JAX-WS) endpoint with Fabric3.
 */
@Component
@Composite
@EagerInit
@WebService
@WebServiceBinding(uri = "ledgerSystem")
public class LedgerSystemImpl implements LedgerSystem {
    private DatatypeFactory factory;

    @Init
    public void init() throws DatatypeConfigurationException {
        factory = DatatypeFactory.newInstance();
    }

    @Monitor
    protected MonitorChannel monitor;

    @WebMethod
    public AccountLedger getLedger(String id) {
        monitor.info("Ledger system invoked");

        LedgerEntry entry1 = createLedgerEntry(50.50, "Lux Cinema", 1, LedgerEntry.STATUS_POSTED);
        LedgerEntry entry2 = createLedgerEntry(44.20, "Cafe de Paris", 2, LedgerEntry.STATUS_POSTED);
        LedgerEntry entry3 = createLedgerEntry(100.35, "Foo Sporting Goods", 4, LedgerEntry.STATUS_POSTED);
        LedgerEntry entry4 = createLedgerEntry(80.00, "Gas", 0, LedgerEntry.STATUS_PROCESSING);

        return new AccountLedger(new LedgerEntry[]{entry1, entry2, entry3, entry4});
    }

    private LedgerEntry createLedgerEntry(double amount, String description, int days, int status) {
        LedgerEntry entry = new LedgerEntry();
        entry.setStatus(status);
        entry.setAmount(BigDecimal.valueOf(amount).setScale(2, BigDecimal.ROUND_DOWN));
        entry.setDescription(description);
        XMLGregorianCalendar date = createDate(days);
        entry.setDate(date);
        return entry;
    }

    private XMLGregorianCalendar createDate(int days) {
        GregorianCalendar date = new GregorianCalendar();
        date.setTimeInMillis(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(days));
        return factory.newXMLGregorianCalendar(date);
    }
}
