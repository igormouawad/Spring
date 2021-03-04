package br.com.mouawad.estudos.spring.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mouawad.estudos.spring.domain.Cliente;
import br.com.mouawad.estudos.spring.repositories.ClienteRepository;
import br.com.mouawad.estudos.spring.resources.ClienteResource;
import br.com.mouawad.estudos.spring.services.exeptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EmailService emailService;
	private Random r = new Random();

	public void sendNewPassword(String email) {
		Cliente cliente = clienteService.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não encontrado");
		}
		String newPass = newPassword();
		System.out.println("#######################################################################################");
		System.out.println(cliente.getId());
		System.out.println(newPass);
		System.out.println("#######################################################################################");
		cliente.setSenha(bCryptPasswordEncoder.encode(newPass));
		
		clienteRepository.save(cliente);

		emailService.sendNewPasswordEmail(cliente, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i = 0; i < 10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = r.nextInt(3);

		if (opt == 0) {
			return ((char) (r.nextInt(10) + 48)); //Digito
		}
		else if( opt == 1)
			return ((char) (r.nextInt(26) + 65)); //Maiuscula
		else 
			return ((char) (r.nextInt(26) + 97)); //Minuscula
		
	}

}
