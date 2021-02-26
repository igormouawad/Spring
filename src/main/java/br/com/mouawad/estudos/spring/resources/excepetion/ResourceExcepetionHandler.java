package br.com.mouawad.estudos.spring.resources.excepetion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.mouawad.estudos.spring.services.exeptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExcepetionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		StandartError error = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
