package br.com.microservice.loja.loja.controller.requestDTO;

import lombok.Data;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ToString
public class CompraRequest {

    @Valid
    @NotNull
    private List<ItemRequest> itens;

    @NotNull
    private EnderecoRequest endereco;
}
