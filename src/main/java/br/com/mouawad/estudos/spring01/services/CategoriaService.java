package br.com.mouawad.estudos.spring01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring01.domain.Categoria;
import br.com.mouawad.estudos.spring01.repositories.CategoriaRepository;
import br.com.mouawad.estudos.spring01.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService  {

	//Inject
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> e = categoriaRepository.findById(id); //Executa o metodo findById de CategoriaRepository
		return e.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		//return  obj.orElseThrow() ; Retorna uma exception se o valor não for presente
		//return  ((Optional<Categoria>)repo.findById(id)).orElse(null); Retorna null se o valor nao for presente
		
	}
	
}
