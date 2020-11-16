package br.com.microservice.fornecedor.fornecedor.controller;

import br.com.microservice.fornecedor.fornecedor.controller.requestDTO.ItemDoPedidoRequest;
import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pedido")
public class PedidoCtrl {

    private final PedidoService pedidoService;

    public PedidoCtrl(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/{id}")
    public Pedido getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }

    @PostMapping()
    public Pedido realizaPedido(@RequestBody List<ItemDoPedidoRequest> produtos) {
        return pedidoService.realizaPedido(produtos);
    }

}
