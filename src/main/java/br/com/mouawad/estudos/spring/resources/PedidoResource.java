package br.com.mouawad.estudos.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mouawad.estudos.spring.domain.Pedido;
import br.com.mouawad.estudos.spring.services.PedidoService;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {
	
	//Inject
	@Autowired
	private PedidoService service;

	/*
	 * Mapeia as chamadas ao endpoint /categorias/{id} no metodo find(), passando
	 * o paramentro id
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Pedido obj = service.buscar(id); //Metodo buscar de PedidoService
		return ResponseEntity.ok().body(obj);
	}
}
