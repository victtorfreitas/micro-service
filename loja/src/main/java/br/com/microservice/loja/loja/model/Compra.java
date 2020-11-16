package br.com.microservice.loja.loja.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Compra {
    private Long pedidoId;
    private Integer tempoDePreparo;
    private String enderecoDestino;
}
