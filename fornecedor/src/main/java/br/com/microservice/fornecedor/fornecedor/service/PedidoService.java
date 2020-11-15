package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

}

