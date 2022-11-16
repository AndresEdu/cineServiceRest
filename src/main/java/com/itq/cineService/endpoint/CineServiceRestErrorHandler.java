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

/*
 * CineServiceRestErrorHandler
 * provee mensajes tanto en consola 
 * como en log sobre los errores que 
 * surjan durante la ejecución de la API
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CineServiceRestErrorHandler{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	protected ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {		
		// Mensaje detallado de lo que provocó el error 
		String mensajeDetallado = ex.getCause().getMessage();
		
		// Remover detalles de la estructura del proyecto expuestos en mensajeDetallado
		String causa = mensajeDetallado.split("\\R")[0];
		
		if(causa.contains("com.itq.cineService.dto.")) {
			causa = causa.replace("com.itq.cineService.dto.", "");
		}
		
		// Construir mensaje de error
		String mensaje = "Solicitud JSON con valores no validos. " + causa;
		ErrorResponse error = new ErrorResponse(HttpStatus.UNPROCESSABLE_ENTITY, mensaje);		
		
		logger.error(mensaje + "\n" + mensajeDetallado);
		
		return new ResponseEntity<>(error, error.getStatus());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {		
		// Obtener causa del error
		String causa = ex.getFieldError().getDefaultMessage();
		
		// Obtener campo donde ocurrió el error
		String campo = ex.getFieldError().getField();
		
		// Construir mensaje de error
		String mensaje = "Solicitud JSON mal construida, campo " + campo + ": " + causa;
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, mensaje);		
		
		logger.error(mensaje + "\n" + error.getMessage() + "\n" + ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, error.getStatus());
	}
	
	@ExceptionHandler(NotValidIdException.class)
	protected ResponseEntity<Object> handleNotValidIdExceptiont(NotValidIdException ex) {		
		// Construir mensaje donde ocurrió el error
		String mensaje = ex.getMessage();
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, mensaje);		
		
		logger.error(mensaje + "\n" + error.getMessage() + "\n" + ex.getLocalizedMessage());
		
		return new ResponseEntity<>(error, error.getStatus());
	}
}
