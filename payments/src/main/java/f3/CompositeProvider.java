package f3;

import javax.xml.namespace.QName;
import java.util.Collections;
import java.util.List;

import org.fabric3.api.annotation.model.Provides;
import org.fabric3.api.binding.zeromq.builder.ZeroMQBindingDefinitionBuilder;
import org.fabric3.api.binding.zeromq.model.ZeroMQBindingDefinition;
import org.fabric3.api.model.type.builder.ChannelDefinitionBuilder;
import org.fabric3.api.model.type.builder.CompositeBuilder;
import org.fabric3.api.model.type.component.ChannelDefinition;
import org.fabric3.api.model.type.component.Composite;

/**
 * Demonstrates the Fabric3 DSL for creating a composite.
 */
public class CompositeProvider {
    private static final QName COMPOSITE = new QName("urn:bigbank.org", "PaymentComposite");

    @Provides
    public static Composite createComposite() {
        // Creates a channel bound to a ZeroMQ socket. Publishers and subscribers to the channel will communicate via a ZeroMQ PUB/SUB socket.
        List<String> addresses = Collections.singletonList("localhost:8383");
        ZeroMQBindingDefinition binding = ZeroMQBindingDefinitionBuilder.newBuilder().address(addresses).build();
        ChannelDefinition channel = ChannelDefinitionBuilder.newBuilder("FraudChannel").binding(binding).build();
        return CompositeBuilder.newBuilder(COMPOSITE).channel(channel).deployable().build();
    }
}
