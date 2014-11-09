package org.fabric3.samples.bigbank.fraud;

import org.fabric3.api.MonitorChannel;
import org.fabric3.api.annotation.Consumer;
import org.fabric3.api.annotation.model.Component;
import org.fabric3.api.annotation.monitor.Monitor;
import org.fabric3.api.annotation.scope.Composite;

/**
 * A sample fraud detector that receives message from a channel bound to a ZeroMQ socket. The channel is defined using the Fabric3 DSL by {@link f3
 * .CompositeProvider}.
 */
@Composite
@Component
public class FraudDetector {

    @Monitor
    protected MonitorChannel monitor;

    @Consumer(source = "FraudChannel")
    public void onEvent(byte[] data) {
        monitor.info("Received fraud detection data: " + new String(data));
    }
}
