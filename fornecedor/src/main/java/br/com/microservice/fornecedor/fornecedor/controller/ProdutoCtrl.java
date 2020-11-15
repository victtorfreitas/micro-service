package br.com.microservice.fornecedor.fornecedor.controller;

import br.com.microservice.fornecedor.fornecedor.model.Produto;
import br.com.microservice.fornecedor.fornecedor.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoCtrl {

    private final ProdutoService produtoService;

    public ProdutoCtrl(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/{estado}")
    public List<Produto> getProductByState(@PathVariable("estado") String estado) {
        return produtoService.getProductByState(estado);
    }
}
