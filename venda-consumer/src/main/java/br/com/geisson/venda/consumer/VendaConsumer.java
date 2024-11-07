package br.com.geisson.venda.consumer;

import io.smallrye.common.annotation.Blocking;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import java.util.concurrent.CompletionStage;

@ApplicationScoped
public class VendaConsumer {

    private static final Logger LOGGER = Logger.getLogger(VendaConsumer.class);

    @Incoming("vendas")
    @Blocking
    public CompletionStage<Void> process(Message<JsonObject> message) throws InterruptedException {
        Venda venda = message.getPayload().mapTo(Venda.class);
        LOGGER.infof("Recebida venda %d", venda.getId());
        Thread.sleep(1000);
        return message.ack();
    }
}
