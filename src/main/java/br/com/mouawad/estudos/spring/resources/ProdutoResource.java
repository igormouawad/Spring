package br.com.mouawad.estudos.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.mouawad.estudos.spring.domain.Produto;
import br.com.mouawad.estudos.spring.dto.ProdutoDTO;
import br.com.mouawad.estudos.spring.resources.utils.URL;
import br.com.mouawad.estudos.spring.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	// Inject
	@Autowired
	private ProdutoService service;

	/*
	 * Mapeia as chamadas ao endpoint /Produtos/{id} no metodo find(), passando o
	 * paramentro id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = service.find(id); // Metodo buscar de ProdutoService
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="nome",defaultValue = "") String nome,
			@RequestParam(value="categorias",defaultValue = "") String categorias,
			@RequestParam(value="page",defaultValue = "0") Integer page,
			@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage,
			@RequestParam(value="orderBy",defaultValue = "nome") String orderBy,
			@RequestParam(value="direction",defaultValue = "ASC") String direction) {
		List<Integer> ids = URL.decodeIntList(categorias);
		Page<Produto> list = service.findProduto(URL.decodeParam(nome),ids,page,linesPerPage,orderBy,direction);
		
		Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj)); 
		
//		Page<ProdutoDTO> listDTO = list.stream().map(obj -> new ProdutoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
}
