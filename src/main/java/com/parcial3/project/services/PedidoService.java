package com.parcial3.project.services;
import com.parcial3.project.models.Pedido;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {
    private final List<Pedido> pedidos = new ArrayList<>();

    public PedidoService() {
        pedidos.add(new Pedido("1sd3jhr3f7h3562f3", "Pedido de prueba pre-cargado", 300.0));
    }

    public Flux<Pedido> obtenerPedidos() {
        return Flux.fromIterable(pedidos);
    }

    public Mono<Pedido> crearPedido(Pedido pedido) {
        pedido = new Pedido(UUID.randomUUID().toString(), pedido.getDescripcion(), pedido.getTotal());
        pedidos.add(pedido);
        return Mono.just(pedido);
    }
}
