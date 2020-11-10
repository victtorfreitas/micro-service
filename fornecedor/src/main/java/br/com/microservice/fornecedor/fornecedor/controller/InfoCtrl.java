package br.com.microservice.fornecedor.fornecedor.controller;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.fornecedor.service.InfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoCtrl {

    private final InfoService infoService;

    public InfoCtrl(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/{estado}")
    public InfoFornecedor getInfoByState(@PathVariable String estado){
        return infoService.getInfoByState(estado);
    }
}
