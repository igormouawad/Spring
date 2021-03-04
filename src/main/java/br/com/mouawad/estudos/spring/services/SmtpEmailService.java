package br.com.mouawad.estudos.spring.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import br.com.mouawad.estudos.spring.domain.Cliente;

public class SmtpEmailService extends AbastractEmailService {

	private static final Logger LOG = LoggerFactory.getLogger(SmtpEmailService.class);

	
	@Autowired
	private MailSender mailSender;
	
	@Override
	public void sendMail(SimpleMailMessage msg) {
		LOG.info("Enviando Email");
		mailSender.send(msg);
		LOG.info("Email enviado");
		
	}



}
