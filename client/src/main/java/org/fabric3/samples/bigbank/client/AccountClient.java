package org.fabric3.samples.bigbank.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import java.math.BigDecimal;

import org.fabric3.samples.bigbank.api.services.account.Account;
import org.glassfish.jersey.jackson.JacksonFeature;
import static java.math.BigDecimal.ROUND_DOWN;

/**
 * Queries account data using the JAX-RS client API.
 */
public class AccountClient {
    private static final String ACCOUNTS_URL = "http://localhost:8181/accounts";
    private static final BigDecimal DIVISOR = BigDecimal.valueOf(100);

    public static void main(String... args) {
        Client client = createClient();

        Invocation.Builder request = client.target(ACCOUNTS_URL + "/123").request();
        Account account = request.buildGet().invoke(Account.class);

        System.out.println("Account balance: " + convert(account.getBalance()));
        System.out.println("Safe spending limit: " + convert(account.getSafeToSpend()));
    }

    private static String convert(int amount) {
        return BigDecimal.valueOf(amount).setScale(2, ROUND_DOWN).divide(DIVISOR, ROUND_DOWN).toString();
    }

    private static Client createClient() {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        return client;
    }

}
