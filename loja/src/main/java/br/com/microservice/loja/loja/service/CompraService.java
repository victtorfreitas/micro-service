package br.com.microservice.loja.loja.service;

import br.com.microservice.loja.loja.controller.requestDTO.CompraRequest;
import br.com.microservice.loja.loja.service.responseDTO.InfoFornecedorResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class CompraService {

    private static final String URL_INFO_FORNECEDOR = "http://localhost:8081/info/";

    public void realizaCompra(CompraRequest compra) {
        RestTemplate client = new RestTemplate();
        ResponseEntity<InfoFornecedorResponse> resposta = client.exchange(URL_INFO_FORNECEDOR + compra.getEndereco().getEstado(),
                HttpMethod.GET,
                null,
                InfoFornecedorResponse.class);
        System.out.println(Objects.requireNonNull(resposta.getBody()).getEndereco());
    }
}
