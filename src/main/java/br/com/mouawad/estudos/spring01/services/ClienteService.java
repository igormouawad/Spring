package br.com.mouawad.estudos.spring01.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mouawad.estudos.spring01.domain.Cliente;
import br.com.mouawad.estudos.spring01.repositories.ClienteRepository;
import br.com.mouawad.estudos.spring01.services.exeptions.ObjectNotFoundException;

@Service
public class ClienteService  {

	//Inject
	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> e = clienteRepository.findById(id); 
		return e.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));

		
	}
	
}
