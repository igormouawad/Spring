package br.com.mouawad.estudos.spring01;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import br.com.mouawad.estudos.spring01.domain.Categoria;
import br.com.mouawad.estudos.spring01.domain.Cidade;
import br.com.mouawad.estudos.spring01.domain.Cliente;
import br.com.mouawad.estudos.spring01.domain.Endereco;
import br.com.mouawad.estudos.spring01.domain.Estado;
import br.com.mouawad.estudos.spring01.domain.Pagamento;
import br.com.mouawad.estudos.spring01.domain.PagamentoComBoleto;
import br.com.mouawad.estudos.spring01.domain.PagamentoComCartao;
import br.com.mouawad.estudos.spring01.domain.Pedido;
import br.com.mouawad.estudos.spring01.domain.Produto;
import br.com.mouawad.estudos.spring01.domain.enums.EstadoPagamento;
import br.com.mouawad.estudos.spring01.domain.enums.TipoCliente;
import br.com.mouawad.estudos.spring01.repositories.CategoriaRepository;
import br.com.mouawad.estudos.spring01.repositories.CidadeRepository;
import br.com.mouawad.estudos.spring01.repositories.ClienteRepository;
import br.com.mouawad.estudos.spring01.repositories.EnderecoRepository;
import br.com.mouawad.estudos.spring01.repositories.EstadoRepository;
import br.com.mouawad.estudos.spring01.repositories.PagamentoRepository;
import br.com.mouawad.estudos.spring01.repositories.PedidoRepository;
import br.com.mouawad.estudos.spring01.repositories.ProdutoRepository;

@SpringBootApplication
public class EstudoSpringApplication implements CommandLineRunner{

	
	@Autowired													
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository ;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritorio");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",800.00);
		Produto p3 = new Produto(null,"Mouse",80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
				
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		Estado est1 = new Estado(null,"Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Urbelandia", est1);
		Cidade c2 = new Cidade(null,"Taubaté", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "MAria Silva", "maria@gmail.com", "341332", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("2131231","5555555555"));
		
		
				
		Endereco e1 = new Endereco(null, "Voluntário", "940","Rua 1 casa 182","12053-000" ,"Estiva", cli1, c1);
		
		Endereco e2 = new Endereco(null,"rua Equador","161", "", "1247-000", "Jd. das Nacoes", cli1,c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2019 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null,EstadoPagamento.QUITADO,ped1,6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null,EstadoPagamento.PENDENTE,ped2,sdf.parse("20/10/2017 00:00"),null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		
	}

}
