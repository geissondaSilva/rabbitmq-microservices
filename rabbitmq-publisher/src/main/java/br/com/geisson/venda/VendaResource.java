package br.com.geisson.venda;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.jboss.logging.Logger;

import java.util.UUID;

@Path("/venda")
public class VendaResource {

    private static final Logger LOGGER = Logger.getLogger(VendaResource.class);

    @Channel("vendas")
    Emitter<Venda> vendasEmitter;

    @Inject
    VendaRepository repository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Venda venda) {
        repository.create(venda);
        LOGGER.infof("Venda %d criada com sucesso!", venda.getId());
        vendasEmitter.send(venda);
    }
}
