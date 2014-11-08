package f3;

import javax.xml.namespace.QName;
import java.util.Collections;

import org.fabric3.api.annotation.model.Provides;
import org.fabric3.api.binding.zeromq.builder.ZeroMQBindingDefinitionBuilder;
import org.fabric3.api.binding.zeromq.model.ZeroMQBindingDefinition;
import org.fabric3.api.model.type.builder.ChannelDefinitionBuilder;
import org.fabric3.api.model.type.builder.CompositeBuilder;
import org.fabric3.api.model.type.component.ChannelDefinition;
import org.fabric3.api.model.type.component.Composite;

/**
 * Demonstrates use of the Fabric3 DSL for creating a composite.
 */
public class CompositeProvider {
    private static final QName COMPOSITE = new QName("urn:bigbank.org", "PaymentComposite");

    @Provides
    public static Composite createComposite() {
        // creates a channel bound to a ZeroMQ socket
        ZeroMQBindingDefinition binding = ZeroMQBindingDefinitionBuilder.newBuilder().address(Collections.singletonList("localhost:8383")).build();
        ChannelDefinition channel = ChannelDefinitionBuilder.newBuilder("FraudChannel").binding(binding).build();
        return CompositeBuilder.newBuilder(COMPOSITE).channel(channel).deployable().build();
    }
}
