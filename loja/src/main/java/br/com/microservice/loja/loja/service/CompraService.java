package br.com.microservice.loja.loja.service;

import br.com.microservice.loja.loja.config.FornecedorClient;
import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import br.com.microservice.loja.loja.controller.responseDTO.InfoPedidoResponse;
import br.com.microservice.loja.loja.model.Compra;
import org.springframework.stereotype.Service;

@Service
public class CompraService {

    private final FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public Compra realizaCompra(CompraRequest compra) {
        InfoPedidoResponse pedidoResponse = fornecedorClient.realizaPedido(compra.getItens());
        return montaCompra(compra, pedidoResponse);
    }

    private Compra montaCompra(CompraRequest compra, InfoPedidoResponse pedidoResponse) {
        return Compra.builder()
                .pedidoId(pedidoResponse.getId())
                .tempoDePreparo(pedidoResponse.getTempoDePreparo())
                .enderecoDestino(compra.getEndereco().toString())
                .build();
    }
}
