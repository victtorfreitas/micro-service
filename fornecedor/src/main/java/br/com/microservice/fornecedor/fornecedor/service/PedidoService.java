package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.controller.requestDTO.ItemDoPedidoRequest;
import br.com.microservice.fornecedor.fornecedor.model.Pedido;
import br.com.microservice.fornecedor.fornecedor.model.PedidoItem;
import br.com.microservice.fornecedor.fornecedor.model.Produto;
import br.com.microservice.fornecedor.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.fornecedor.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ProdutoRepository produtoRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
    }

    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    public Pedido realizaPedido(List<ItemDoPedidoRequest> itens) {
        if (itens == null) {
            return null;
        }
        List<PedidoItem> pedidoItens = toPedidoItem(itens);
        Pedido pedido = new Pedido(pedidoItens);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }

    private List<PedidoItem> toPedidoItem(List<ItemDoPedidoRequest> itens) {

        List<Long> idsProdutos = getIdItens(itens);

        List<Produto> produtosDoPedido = produtoRepository.findByIdIn(idsProdutos);

        return itens.stream()
                .map(item -> getPedidoItem(produtosDoPedido, item))
                .collect(Collectors.toList());
    }

    private List<Long> getIdItens(List<ItemDoPedidoRequest> itens) {
        return itens
                .stream()
                .map(ItemDoPedidoRequest::getId)
                .collect(Collectors.toList());
    }

    private PedidoItem getPedidoItem(List<Produto> produtosDoPedido, ItemDoPedidoRequest item) {
        Produto produto = getProdutoByItemId(produtosDoPedido, item);
        return montaPedidoItem(item, produto);
    }

    private PedidoItem montaPedidoItem(ItemDoPedidoRequest item, Produto produto) {
        return PedidoItem.builder()
                .produto(produto)
                .quantidade(item.getQuantidade())
                .build();
    }


    private Produto getProdutoByItemId(List<Produto> produtosDoPedido, ItemDoPedidoRequest item) {
        return produtosDoPedido
                .stream()
                .filter(p -> p.getId() == item.getId())
                .findFirst().orElseThrow(() -> new RuntimeException("Erro ao buscar Produto por Item ID"));
    }
}

