package br.com.mouawad.estudos.spring.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mouawad.estudos.spring.domain.Categoria;
import br.com.mouawad.estudos.spring.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	
	//Inject
	@Autowired
	private CategoriaService service;

	/*
	 * Mapeia as chamadas ao endpoint /categorias/{id} no metodo find(), passando
	 * o paramentro id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Categoria obj = service.buscar(id); //Metodo buscar de CategoriaService
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		
		return ResponseEntity.created(uri).build();
	}

}


