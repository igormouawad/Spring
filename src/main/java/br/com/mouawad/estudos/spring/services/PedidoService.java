package br.com.mouawad.estudos.spring.services;


import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.ItemPedido;
import br.com.mouawad.estudos.spring.domain.PagamentoComBoleto;
import br.com.mouawad.estudos.spring.domain.Pedido;
import br.com.mouawad.estudos.spring.domain.enums.EstadoPagamento;
import br.com.mouawad.estudos.spring.repositories.ItemPedidoRepository;
import br.com.mouawad.estudos.spring.repositories.PagamentoRepository;
import br.com.mouawad.estudos.spring.repositories.PedidoRepository;
import br.com.mouawad.estudos.spring.services.exeptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private BoletoService boletoService;
	
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private PagamentoService pagamentoService;
	@Autowired
	private ItemPedidoService itemPedidoService;
	

	
	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
	
	public Pedido insert(Pedido obj) {
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		obj = repo.save(obj);
		pagamentoService.insert(obj.getPagamento());
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPreco());
			ip.setPedido(obj);
		}
		itemPedidoService.insert(obj.getItens());

		return obj;
	}
	

}