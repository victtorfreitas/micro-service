package br.com.microservice.fornecedor.fornecedor.service;


import br.com.microservice.fornecedor.fornecedor.model.Produto;
import br.com.microservice.fornecedor.fornecedor.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> getProductByState(String estado) {
		return produtoRepository.findByEstado(estado);
	}

	
}
