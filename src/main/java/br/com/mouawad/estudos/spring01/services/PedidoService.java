package br.com.mouawad.estudos.spring01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mouawad.estudos.spring01.domain.Pedido;
import br.com.mouawad.estudos.spring01.repositories.PedidoRepository;
import br.com.mouawad.estudos.spring01.services.exeptions.ObjectNotFoundException;

@Service
public class PedidoService  {

	//Inject
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> e = pedidoRepository.findById(id); 
		return e.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));

		
	}
	
}
