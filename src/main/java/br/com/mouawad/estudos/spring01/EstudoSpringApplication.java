package br.com.mouawad.estudos.spring01;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mouawad.estudos.spring01.domain.Categoria;
import br.com.mouawad.estudos.spring01.repositories.CategoriaRepository;

@SpringBootApplication
public class EstudoSpringApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
	}

}
