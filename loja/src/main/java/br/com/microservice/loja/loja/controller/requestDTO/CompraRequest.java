package br.com.microservice.loja.loja.controller.requestDTO;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class CompraRequest {

    @Valid
    @NotNull
    private List<ItemRequest> itens;

    @NotNull
    private EnderecoRequest endereco;
}
