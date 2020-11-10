package br.com.microservice.fornecedor.fornecedor.service;

import br.com.microservice.fornecedor.fornecedor.model.InfoFornecedor;
import br.com.microservice.fornecedor.fornecedor.repository.InfoRepository;
import org.springframework.stereotype.Service;

@Service
public class InfoService {

    private final InfoRepository infoRepository;

    public InfoService(InfoRepository infoRepository) {
        this.infoRepository = infoRepository;
    }

    public InfoFornecedor getInfoByState(String estado){
        return infoRepository.findByEstado(estado);
    }
}
