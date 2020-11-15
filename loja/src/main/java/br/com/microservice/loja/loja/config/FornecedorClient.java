package br.com.microservice.loja.loja.config;

import br.com.microservice.loja.loja.service.responseDTO.InfoFornecedorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorResponse getInfoByState(@PathVariable String estado);
}
