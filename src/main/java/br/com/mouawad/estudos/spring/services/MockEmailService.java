package br.com.mouawad.estudos.spring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

import br.com.mouawad.estudos.spring.domain.Cliente;

public class MockEmailService extends AbastractEmailService {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void sendMail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de Email");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
		
	}



}
