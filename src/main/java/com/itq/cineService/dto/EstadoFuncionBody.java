package com.itq.cineService.dto;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/*
 * La clase EstadoFuncionBody es un auxiliar
 * para la construcción del JSON que se pasa 
 * como body para el metodo putEstadoFuncion
 * de la clase CineServiceController.
 */
public class EstadoFuncionBody {
	
	@NotNull
	private Integer idFuncion;
	
	@NotNull		
	@Enumerated(EnumType.STRING)
	private estadoFuncion estado;	

	public estadoFuncion getEstado() {
		return estado;
	}

	public void setEstado(estadoFuncion estado) {
		this.estado = estado;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}

		

}
