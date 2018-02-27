package com.sistema.ws;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.ws.domain.Categoria;
import com.sistema.ws.repositories.CategoriaRepository;

@SpringBootApplication
public class WsApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(WsApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Carnes");
		Categoria cat2 = new Categoria(null, "Leguminosas");
		
		categoriaRepository.save(Arrays.asList(cat1, cat2));
	}
	
}
