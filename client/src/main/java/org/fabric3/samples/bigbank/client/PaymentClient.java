package org.fabric3.samples.bigbank.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.fabric3.samples.bigbank.api.services.payments.Payment;
import org.glassfish.jersey.jackson.JacksonFeature;

/**
 * Submits a funds transfer between two accounts.
 */
public class PaymentClient {
    private static final String PAYMENTS_URL = "http://localhost:8181/payments";

    public static void main(String... args) {
        Client client = createClient();

        Payment payment = new Payment("123", "567", 10005, "Reimbursement for dinner");
        Entity<Payment> entity = Entity.entity(payment, MediaType.APPLICATION_JSON_TYPE);
        Invocation request = client.target(PAYMENTS_URL).request().buildPut(entity);

        Response response = request.invoke();

        int status = response.getStatus();
        if (Response.Status.CREATED.getStatusCode() == status) {
            System.out.println("Payment sent");
        } else {
            System.out.println("Error sending payment: " + status);
        }
    }

    private static Client createClient() {
        Client client = ClientBuilder.newClient();
        client.register(JacksonFeature.class);
        return client;
    }
}
