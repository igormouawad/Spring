package br.com.mouawad.estudos.spring.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.Categoria;
import br.com.mouawad.estudos.spring.repositories.CategoriaRepository;
import br.com.mouawad.estudos.spring.services.exeptions.DataIntegrityException;
import br.com.mouawad.estudos.spring.services.exeptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	// Inject
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria find(Integer id) {
		Optional<Categoria> e = categoriaRepository.findById(id); // Executa o metodo findById de CategoriaRepository
		return e.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		// return obj.orElseThrow() ; Retorna uma exception se o valor não for presente
		// return ((Optional<Categoria>)repo.findById(id)).orElse(null); Retorna null se
		// o valor nao for presente

	}

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}

	public Categoria update(Categoria obj) {
		return categoriaRepository.save(obj);
	}
	
	public void delete(Integer id) {
		try {
		categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
		}
	}
}
