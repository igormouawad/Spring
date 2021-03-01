package br.com.mouawad.estudos.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.Categoria;
import br.com.mouawad.estudos.spring.domain.Produto;
import br.com.mouawad.estudos.spring.repositories.CategoriaRepository;
import br.com.mouawad.estudos.spring.repositories.ProdutoRepository;
import br.com.mouawad.estudos.spring.services.exeptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	// Inject
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Produto find(Integer id) {
		Optional<Produto> e = produtoRepository.findById(id);
		return e.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));

	}
	

	
	public Page<Produto> findProduto(String nome, List<Integer> ids, Integer page,Integer linesPerPage, String orderBy, String direction) {
		PageRequest pagRequest = PageRequest.of(page, linesPerPage,Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias,pagRequest);

		
	}
	
	public Produto insert(Produto obj) {
		obj.setId(null);
			return produtoRepository.save(obj);	
	}
}
