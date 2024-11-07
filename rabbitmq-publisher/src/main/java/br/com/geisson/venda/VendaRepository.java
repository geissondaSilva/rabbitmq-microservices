package br.com.geisson.venda;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VendaRepository {

    private static int sequence = 0;

    public void create(Venda venda) {
        venda.setId((long) sequence++);
    }
}
