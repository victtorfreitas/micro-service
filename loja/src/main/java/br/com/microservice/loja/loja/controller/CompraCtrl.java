package br.com.microservice.loja.loja.controller;

import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import br.com.microservice.loja.loja.model.Compra;
import br.com.microservice.loja.loja.service.CompraService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraCtrl {
    private final CompraService compraService;

    public CompraCtrl(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public Compra realizarCompra(@Valid @RequestBody CompraRequest compra){
        return compraService.realizaCompra(compra);
    }
}
