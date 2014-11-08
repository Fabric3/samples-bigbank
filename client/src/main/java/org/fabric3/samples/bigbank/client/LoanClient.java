package org.fabric3.samples.bigbank.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 */
public class LoanClient {
    private static final String LOAN_URL = "http://localhost:8181/loan";

    public static void main(String... args) {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        Invocation.Builder request = client.target(LOAN_URL + "/apply").request();
        String reply = request.buildPut(Entity.entity("123", MediaType.APPLICATION_JSON)).invoke(String.class);

        System.out.println("Reply: " + reply);
    }
}
