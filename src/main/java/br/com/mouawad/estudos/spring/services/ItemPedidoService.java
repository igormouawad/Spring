package br.com.mouawad.estudos.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.ItemPedido;
import br.com.mouawad.estudos.spring.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	// Inject
	@Autowired
	private ItemPedidoRepository ItemPedidoRepository;


	public List<ItemPedido> insert(Set<ItemPedido> obj) {
			return ItemPedidoRepository.saveAll(obj);	
	}
}
