package com.itq.cineService.endpoint;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {

	private HttpStatus status; // Código de respuesta HTTP 
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp; // Fecha y hora cuando ocurrió el error
	private String message;	// Mensaje descriptivo del error
	
	// Constructor base
	private ErrorResponse() {
		timestamp = LocalDateTime.now();
	}

	// Constructor con estado
	ErrorResponse(HttpStatus status) {
		this();
		this.status = status;
	}

	// Constructor con mensaje específico de la excepción
	ErrorResponse(HttpStatus status, Throwable ex) {
		this();
		this.status = status;
		this.message = ex.getMessage();		
	}
	
	// Constructor con mensaje como parámetro
	ErrorResponse(HttpStatus status, String message) {
		this();
		this.status = status;
		this.message = message;
	}

	
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	/**
	 * @return the timestamp
	 */
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}


}