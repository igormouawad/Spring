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
import br.com.mouawad.estudos.spring.services.S3Service;

@SpringBootApplication
public class EstudoSpringApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;
	
	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3Service.uploadFile("C:\\Users\\igor\\Pictures\\20201022_175028.jpg");

	}

}
