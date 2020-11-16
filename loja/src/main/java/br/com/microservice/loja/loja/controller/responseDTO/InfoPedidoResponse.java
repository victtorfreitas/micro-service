package br.com.microservice.loja.loja.controller.responseDTO;

import lombok.Data;

@Data
public class InfoPedidoResponse {
    private Long id;
    private Integer tempoDePreparo;
}
