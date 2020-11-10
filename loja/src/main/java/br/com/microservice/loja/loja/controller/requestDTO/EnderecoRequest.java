package br.com.microservice.loja.loja.controller.requestDTO;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EnderecoRequest {

    @NotBlank
    private String rua;

    @NotBlank
    private String numero;

    @NotBlank
    private String estado;
}
