package br.com.mouawad.estudos.spring.services;

import org.springframework.mail.SimpleMailMessage;

import br.com.mouawad.estudos.spring.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	void sendMail(SimpleMailMessage msg);
}
