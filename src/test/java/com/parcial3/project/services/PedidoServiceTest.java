package com.parcial3.project.services;

import com.parcial3.project.models.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;


class PedidoServiceTest {

    private PedidoService pedidoService;

    @BeforeEach
    void setUp() {
        pedidoService = new PedidoService();
    }

    @Test
    void testObtenerPedidos() {
        StepVerifier.create(pedidoService.obtenerPedidos())
                .expectNextMatches(pedido -> pedido.getDescripcion().contains("Pedido"))
                .expectNextCount(0) // Solo verificamos el primer pedido
                .expectComplete()
                .verify();
    }

    @Test
    void testCrearPedido() {
        Pedido nuevoPedido = new Pedido("2", "Nuevo Pedido", 500.0);

        StepVerifier.create(pedidoService.crearPedido(nuevoPedido))
                .expectNextMatches(pedido -> pedido.getDescripcion().equals("Nuevo Pedido") && pedido.getTotal() == 500.0)
                .expectComplete()
                .verify();
    }
}
