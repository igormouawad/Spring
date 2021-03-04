package br.com.mouawad.estudos.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.SimpleMailMessage;

import br.com.mouawad.estudos.spring.domain.Pedido;
import br.com.mouawad.estudos.spring.services.EmailService;
import br.com.mouawad.estudos.spring.services.S3Service;
import br.com.mouawad.estudos.spring.services.SmtpEmailService;

@SpringBootApplication
public class EstudoSpringApplication implements CommandLineRunner {

	@Autowired
	private S3Service s3Service;
	

	

	
	public static void main(String[] args) {
		SpringApplication.run(EstudoSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		//s3Service.uploadFile("C:\\Users\\igor\\Pictures\\20201022_175028.jpg");

	}

}
