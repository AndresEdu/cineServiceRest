package com.itq.cineService.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CineServiceRestErrorHandler{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {		
		String causa = ex.getCause().getMessage();
		String mensaje = "Solicitud JSON con valores no validos.\n" + causa;
		ErrorResponse error = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, mensaje);		
		
		logger.error(mensaje + "\n" + error.getMessage() + "\n" + ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, error.getStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {		
		String causa = ex.getFieldError().getDefaultMessage();
		String campo = ex.getFieldError().getField();
		String mensaje = "Solicitud JSON mal construida, campo " + campo + ": " + causa;
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, mensaje);		
		
		logger.error(mensaje + "\n" + error.getMessage() + "\n" + ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@ExceptionHandler(NotValidIdException.class)
	protected ResponseEntity<Object> handleNotValidIdExceptiont(NotValidIdException ex) {		
		String mensaje = ex.getMessage();
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, mensaje);		
		
		logger.error(mensaje + "\n" + error.getMessage() + "\n" + ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, error.getStatus());
	}
}
