package org.fabric3.samples.backend.account;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.math.BigDecimal;

import org.fabric3.api.MonitorChannel;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.api.binding.ws.annotation.WebServiceBinding;
import org.fabric3.samples.bigbank.api.backend.account.AccountsSystem;
import org.fabric3.samples.bigbank.api.backend.account.InternalAccountData;
import org.oasisopen.sca.annotation.EagerInit;

/**
 * A web service simulating a backend legacy account system.
 *
 * This service also demonstrates how to expose a Web Service (JAX-WS) endpoint with Fabric3.
 */
@Component
@Composite
@EagerInit
@WebService
@WebServiceBinding(uri = "accountsSystem")
public class AccountsSystemImpl implements AccountsSystem {

    @Monitor
    protected MonitorChannel monitor;

    @WebMethod
    public InternalAccountData getAccountData(String id) {
        monitor.info("Accounting system invoked");

        BigDecimal balance = BigDecimal.valueOf(2000.20).setScale(2, BigDecimal.ROUND_DOWN);
        return new InternalAccountData(id, balance);
    }

}
