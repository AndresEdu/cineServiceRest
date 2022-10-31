/**
 * 
 */
package com.itq.cineService.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author edugo
 *
 */
public class Asiento {
	
	@NotEmpty
	@NotNull
	private String estado;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^([A-F]{1}[0-9][0-9]?)$")
	private String idAsiento;
	
	@NotEmpty
	@NotNull
	@Max(3)
	@Min(1)
	private String idSala;
	
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the idAsiento
	 */
	public String getIdAsiento() {
		return idAsiento;
	}
	/**
	 * @param idAsiento the idAsiento to set
	 */
	public void setIdAsiento(String idAsiento) {
		this.idAsiento = idAsiento;
	}
	/**
	 * @return the idSala
	 */
	public String getIdSala() {
		return idSala;
	}
	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(String idSala) {
		this.idSala = idSala;
	}
	
	
		
}
