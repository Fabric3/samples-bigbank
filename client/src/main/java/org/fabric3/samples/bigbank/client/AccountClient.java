package org.fabric3.samples.bigbank.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 */
public class AccountClient {
    private static final String ACCOUNTS = "http://localhost:8181/accounts";

    public static void main(String... args) {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        Invocation.Builder request = client.target(ACCOUNTS + "/123").request();
        Account account = request.buildGet().invoke(Account.class);

        System.out.println("Account balance: " + account.getBalance() / 100);
        System.out.println("Safe spending limit: " + account.getSafeToSpend() / 100);
    }
}
