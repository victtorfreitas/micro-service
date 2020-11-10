package br.com.microservice.loja.loja.controller;

import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraCtrl {

    @PostMapping
    public void realizarCompra(@Valid @RequestBody CompraRequest compra){
        // Comprar
    }
}
