/**
 * 
 */
package com.itq.cineService.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author edugo
 *
 */
@Entity()
@Table(name = "Asiento")
public class Asiento {
	
	@Id
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^([A-F]{1}[0-9][0-9]?)$")
	@Column(name="idAsiento")
	private String idAsiento;
	
	@NotNull
	@Column(name="estado")
	@Enumerated(EnumType.STRING)
	private estadoSala estado;
	
	
	@NotEmpty
	@NotNull
	@Max(3)
	@Min(1)
	@Column(name="idSala")
	private int idSala;
	
	/**
	 * @return the estado
	 */
	public estadoSala getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(estadoSala estado) {
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
	public int getIdSala() {
		return idSala;
	}
	/**
	 * @param idSala the idSala to set
	 */
	public void setIdSala(int idSala) {
		this.idSala = idSala;
	}
	
	
		
}
