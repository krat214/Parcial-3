package com.parcial3.project.controllers;
import com.parcial3.project.models.PedidoResponse;
import com.parcial3.project.services.PedidoService;
import com.parcial3.project.models.Pedido;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Locale;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    private final MessageSource messageSource;

    public PedidoController(PedidoService pedidoService, MessageSource messageSource) {
        this.pedidoService = pedidoService;
        this.messageSource = messageSource;
    }

    @GetMapping
    public Flux<PedidoResponse> listarPedidos(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return pedidoService.obtenerPedidos()
                .map(p -> {
                    PedidoResponse response = new PedidoResponse();
                    response.setId(p.getId());
                    response.setResponse(messageSource.getMessage("pedido.listado",
                            new Object[]{p.getId(), p.getDescripcion(), p.getTotal()},
                            locale));
                    return response;
                });
    }

    @PostMapping
    public Mono<PedidoResponse> crearPedido(@RequestBody Pedido pedido, @RequestHeader(name = "Accept-Language", required = false) Locale locale) {
        return pedidoService.crearPedido(pedido)
                .map(p -> {
                    PedidoResponse response = new PedidoResponse();
                    response.setId(p.getId());
                    response.setResponse(messageSource.getMessage("pedido.creado", new Object[]{p.getId()}, locale));
                    return response;
                });
    }
}
