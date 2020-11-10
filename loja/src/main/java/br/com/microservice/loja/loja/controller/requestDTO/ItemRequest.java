package br.com.microservice.loja.loja.controller.requestDTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ItemRequest {

    @NotNull
    private Long id;

    @NotNull
    private Integer quantidade;
}
