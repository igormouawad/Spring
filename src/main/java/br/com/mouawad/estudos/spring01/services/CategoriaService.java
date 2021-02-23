package br.com.mouawad.estudos.spring01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring01.domain.Categoria;
import br.com.mouawad.estudos.spring01.repositories.CategoriaRepository;

@Service
public class CategoriaService  {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return  obj.orElse(null);
		//return  ((Optional<Categoria>)repo.findById(id)).orElse(null);
		
	}
	
}
