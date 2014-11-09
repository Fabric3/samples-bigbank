package org.fabric3.samples.bigbank.account;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.math.BigDecimal;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountLedger;
import org.fabric3.samples.bigbank.api.backend.account.AccountsSystem;
import org.fabric3.samples.bigbank.api.backend.account.InternalAccountData;
import org.fabric3.samples.bigbank.api.backend.account.LedgerEntry;
import org.fabric3.samples.bigbank.api.backend.account.LedgerSystem;
import org.fabric3.samples.bigbank.api.services.account.Account;
import org.oasisopen.sca.annotation.Reference;

/**
 * Controller for account resources.
 *
 * This controller is wired to legacy systems that expose WS-* (Web Services) APIs via {@code Reference} annotations. It is responsible for aggregating account
 * balance with ledger entries to provide additional information to end-users such as the "safe-to-spend" calculation.
 */
@EndpointUri("accounts")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class AccountController {
    private static final BigDecimal MULTIPLIER = BigDecimal.valueOf(100);
    private static final BigDecimal MINIMUM_BALANCE = BigDecimal.valueOf(100);

    @Monitor
    protected AccountMonitor monitor;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/accountsSystem")
    protected AccountsSystem accountsSystem;

    @Reference
    @WebServiceBinding(uri = "http://localhost:8182/ledgerSystem")
    protected LedgerSystem ledgerSystem;

    @Path("{accountNumber}")
    @GET
    public Account getAccount(@PathParam("accountNumber") String number) {
        monitor.invoked(number);

        // retrieve account information from the account system
        InternalAccountData internalData = accountsSystem.getAccountData(number);

        // retrieve recent ledger entries for the account
        AccountLedger accountLedger = ledgerSystem.getLedger(number);

        // calculate the safe-to-spend value
        BigDecimal balance = internalData.getBalance();
        BigDecimal safeToSpend = balance.subtract(MINIMUM_BALANCE);
        for (LedgerEntry entry : accountLedger.getEntries()) {
            if (LedgerEntry.TYPE_DEBIT == entry.getType() && LedgerEntry.STATUS_PROCESSING == entry.getStatus()) {
                safeToSpend = safeToSpend.subtract(entry.getAmount());
            }
        }
        return new Account(number, balance.multiply(MULTIPLIER).intValue(), safeToSpend.multiply(MULTIPLIER).intValue());
    }

}
