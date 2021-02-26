package br.com.mouawad.estudos.spring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.mouawad.estudos.spring.domain.Categoria;
import br.com.mouawad.estudos.spring.domain.Cidade;
import br.com.mouawad.estudos.spring.domain.Cliente;
import br.com.mouawad.estudos.spring.domain.Endereco;
import br.com.mouawad.estudos.spring.domain.Estado;
import br.com.mouawad.estudos.spring.domain.ItemPedido;
import br.com.mouawad.estudos.spring.domain.Pagamento;
import br.com.mouawad.estudos.spring.domain.PagamentoComBoleto;
import br.com.mouawad.estudos.spring.domain.PagamentoComCartao;
import br.com.mouawad.estudos.spring.domain.Pedido;
import br.com.mouawad.estudos.spring.domain.Produto;
import br.com.mouawad.estudos.spring.domain.enums.EstadoPagamento;
import br.com.mouawad.estudos.spring.domain.enums.TipoCliente;
import br.com.mouawad.estudos.spring.repositories.CategoriaRepository;
import br.com.mouawad.estudos.spring.repositories.CidadeRepository;
import br.com.mouawad.estudos.spring.repositories.ClienteRepository;
import br.com.mouawad.estudos.spring.repositories.EnderecoRepository;
import br.com.mouawad.estudos.spring.repositories.EstadoRepository;
import br.com.mouawad.estudos.spring.repositories.ItemPedidoRepository;
import br.com.mouawad.estudos.spring.repositories.PagamentoRepository;
import br.com.mouawad.estudos.spring.repositories.PedidoRepository;
import br.com.mouawad.estudos.spring.repositories.ProdutoRepository;

@SpringBootApplication
public class EstudoSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		Categoria cat3 = new Categoria(null, "Cama, mesa e banho");
		Categoria cat4 = new Categoria(null, "Eletronicos");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Perfumaria");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Urbelandia", est1);
		Cidade c2 = new Cidade(null, "Taubaté", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "MAria Silva", "maria@gmail.com", "341332", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2131231", "5555555555"));

		Endereco e1 = new Endereco(null, "Voluntário", "940", "Rua 1 casa 182", "12053-000", "Estiva", cli1, c1);

		Endereco e2 = new Endereco(null, "rua Equador", "161", "", "1247-000", "Jd. das Nacoes", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");

		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"),
				null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		ped2.getItems().addAll(Arrays.asList(ip3));

		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip3));
		p3.getItems().addAll(Arrays.asList(ip1));

		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));

	}

}
