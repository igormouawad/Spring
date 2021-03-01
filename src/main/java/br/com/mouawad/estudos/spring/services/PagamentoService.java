package br.com.mouawad.estudos.spring.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.Pagamento;
import br.com.mouawad.estudos.spring.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	// Inject
	@Autowired
	private PagamentoRepository pagamentoRepository;


	public Pagamento insert(Pagamento obj) {
			return pagamentoRepository.save(obj);	
	}
}
