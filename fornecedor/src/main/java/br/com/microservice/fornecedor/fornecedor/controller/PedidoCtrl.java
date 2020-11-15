package br.com.microservice.fornecedor.fornecedor.controller;

import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.service.PedidoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedido")
public class PedidoCtrl {

    private final PedidoService pedidoService;

    public PedidoCtrl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}
