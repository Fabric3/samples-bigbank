package org.fabric3.samples.bigbank.financing;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.math.BigDecimal;

import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.model.EndpointUri;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;
import org.fabric3.samples.bigbank.api.backend.loan.LoanRequest;
import org.fabric3.samples.bigbank.api.services.financing.LoanApplication;
import org.oasisopen.sca.annotation.Reference;
import static java.math.BigDecimal.ROUND_DOWN;

/**
 * Controller for loan resources. Sends applications to the gateway for processing asynchronously. This controller is one-way: responses will be received and
 * sent to the client via the gateway.
 */
@EndpointUri("loan")
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Composite
@Component
public class LoanController {
    private static final BigDecimal DIVISOR = BigDecimal.valueOf(100);

    @Monitor
    protected LoanMonitor monitor;

    @Reference
    protected Gateway gateway;

    @Path("apply")
    @PUT
    public Response apply(LoanApplication app) {
        monitor.invoked(app.getCustomerId());

        LoanRequest request = createRequest(app);

        gateway.apply(request);
        return Response.status(Response.Status.CREATED).build();
    }

    private LoanRequest createRequest(LoanApplication app) {
        LoanRequest request = new LoanRequest();
        request.setCustomerId(app.getCustomerId());
        request.setMerchantId(app.getMerchantId());
        request.setTerm(app.getTerm());
        request.setAmount(new BigDecimal(app.getAmount()).setScale(2, ROUND_DOWN).divide(DIVISOR, ROUND_DOWN));
        return request;
    }

}
