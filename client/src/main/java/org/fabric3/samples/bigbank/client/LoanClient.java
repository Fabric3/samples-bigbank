package org.fabric3.samples.bigbank.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.fabric3.samples.bigbank.api.services.financing.LoanApplication;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 *
 */
public class LoanClient {
    private static final String LOAN_URL = "http://localhost:8181/loan";

    public static void main(String... args) {
        Client client = createClient();

        LoanApplication app = new LoanApplication("123", "MERCHANT01", 2000, 30);
        Entity<LoanApplication> entity = Entity.entity(app, MediaType.APPLICATION_JSON_TYPE);
        Invocation request = client.target(LOAN_URL + "/apply").request().buildPut(entity);

        Response response = request.invoke();

        int status = response.getStatus();
        if (Response.Status.CREATED.getStatusCode() == status) {
            System.out.println("Loan application sent");
        } else {
            System.out.println("Error sending loan application: " + status);
        }
    }

    private static Client createClient() {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        return client;
    }
}
