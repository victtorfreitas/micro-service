package br.com.microservice.loja.loja.config;

import br.com.microservice.loja.loja.controller.requestDTO.ItemRequest;
import br.com.microservice.loja.loja.controller.responseDTO.InfoPedidoResponse;
import br.com.microservice.loja.loja.service.responseDTO.InfoFornecedorResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient("fornecedor")
public interface FornecedorClient {

    @GetMapping("/info/{estado}")
    InfoFornecedorResponse getInfoByState(@PathVariable String estado);

    @PostMapping("/pedido")
    InfoPedidoResponse realizaPedido(List<ItemRequest> itens);
}
