package br.com.mouawad.estudos.spring01.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mouawad.estudos.spring01.domain.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria categoria1 = new Categoria(1,"Informatica");
		Categoria categoria2 = new Categoria(2,"Escritorio");
		
		List<Categoria>  lista = new ArrayList<>();
		lista.add(categoria1);
		lista.add(categoria2);
		
		return lista;
	}
	
}
