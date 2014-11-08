package org.fabric3.samples.bigbank.fraud;

import org.fabric3.api.annotation.Consumer;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.scope.Composite;

/**
 *
 */
@Composite
@Component
public class FraudDetector {

    @Consumer(source = "FraudChannel")
    public void onEvent(String payment) {
    }
}
