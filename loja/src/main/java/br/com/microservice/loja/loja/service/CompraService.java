package br.com.microservice.loja.loja.service;

import br.com.microservice.loja.loja.config.FornecedorClient;
import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import br.com.microservice.loja.loja.service.responseDTO.InfoFornecedorResponse;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CompraService {

    private final FornecedorClient fornecedorClient;

    public CompraService(FornecedorClient fornecedorClient) {
        this.fornecedorClient = fornecedorClient;
    }

    public void realizaCompra(CompraRequest compra) {
        InfoFornecedorResponse infoFornecedor = fornecedorClient.getInfoByState(compra.getEndereco().getEstado());
        System.out.println(Objects.requireNonNull(infoFornecedor).getEndereco());
    }
}
