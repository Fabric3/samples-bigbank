package org.fabric3.samples.bigbank.fraud;

import org.fabric3.api.annotation.Consumer;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.scope.Composite;

/**
 * A sample fraud detector that receives message from a channel bound to a ZeroMQ socket. The channel is defined using the Fabric3 DSL by {@link f3
 * .CompositeProvider}.
 */
@Composite
@Component
public class FraudDetector {

    @Consumer(source = "FraudChannel")
    public void onEvent(String payment) {
    }
}
