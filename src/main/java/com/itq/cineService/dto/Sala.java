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
import javax.validation.constraints.NotNull;

/**
 * @author edugo
 *
 *
 */

@Entity()
@Table(name = "Sala")
public class Sala {

	@Id
	@Min(1)
	@Max(3)
	@Column(name="idSala")
	private int idSala;
	
	@NotNull
	@Min(1)	
	@Max(10)
	@Column(name="cantFilas")
	private int cantFilas;
	
	@NotNull
	@Min(1)	
	@Max(10)
	@Column(name="cantColumnas")
	private int cantColumnas;
	
	@NotNull
	@Column(name="estado")
	@Enumerated(EnumType.STRING)
	private estadoSala estado;
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
	/**
	 * @return the cantFilas
	 */
	public int getCantFilas() {
		return cantFilas;
	}
	/**
	 * @param cantFilas the cantFilas to set
	 */
	public void setCantFilas(int cantFilas) {
		this.cantFilas = cantFilas;
	}
	/**
	 * @return the cantColumnas
	 */
	public int getCantColumnas() {
		return cantColumnas;
	}
	/**
	 * @param cantColumnas the cantColumnas to set
	 */
	public void setCantColumnas(int cantColumnas) {
		this.cantColumnas = cantColumnas;
	}
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
	
	
	
}
