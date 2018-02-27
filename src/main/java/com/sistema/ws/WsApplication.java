package com.sistema.ws;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.ws.domain.Categoria;
import com.sistema.ws.domain.Produto;
import com.sistema.ws.repositories.CategoriaRepository;
import com.sistema.ws.repositories.ProdutoRepository;

@SpringBootApplication
public class WsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Carnes");
		Categoria cat2 = new Categoria(null, "Leguminosas");
		
		Produto p1 = new Produto(null, "Filé", 50.00);
		Produto p2 = new Produto(null, "Picanha", 300.00);
		Produto p3 = new Produto(null, "Alface", 2.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
		produtoRepository.save(Arrays.asList(p1, p2, p3));
	}
	
}
