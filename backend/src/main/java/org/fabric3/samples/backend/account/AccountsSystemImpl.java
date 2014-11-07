package org.fabric3.samples.backend.account;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import java.math.BigDecimal;

import org.fabric3.samples.api.backend.account.AccountsSystem;
import org.fabric3.samples.api.backend.account.InternalAccountData;

/**
 *
 */
@WebService
public class AccountsSystemImpl implements AccountsSystem {

    @WebMethod
    public InternalAccountData getAccountData(String id) {
        return new InternalAccountData("1234", BigDecimal.valueOf(100.05));
    }

    public static void main(String... args) {
        Endpoint.publish("http://localhost:8081/accountSystem", new AccountsSystemImpl());
    }
}
