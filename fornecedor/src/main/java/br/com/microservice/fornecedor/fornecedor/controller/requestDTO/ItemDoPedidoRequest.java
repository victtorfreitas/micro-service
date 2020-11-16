package br.com.microservice.fornecedor.fornecedor.controller.requestDTO;

import lombok.Data;

@Data
public class ItemDoPedidoRequest {
    private long id;
    private int quantidade;
}
