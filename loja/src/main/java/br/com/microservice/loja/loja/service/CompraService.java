package br.com.microservice.loja.loja.service;

import br.com.microservice.loja.loja.config.FornecedorClient;
import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import br.com.microservice.loja.loja.controller.responseDTO.InfoPedidoResponse;
import br.com.microservice.loja.loja.model.Compra;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

@Service
@Log
public class CompraService {

    private final FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public Compra realizaCompra(CompraRequest compra) {
        log.info("Realiza um pedido");
        InfoPedidoResponse pedidoResponse = fornecedorClient.realizaPedido(compra.getItens());
        log.info("Monta retorno Compra");
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
