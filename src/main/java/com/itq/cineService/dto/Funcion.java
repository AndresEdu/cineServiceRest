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
@Table(name = "Funcion")
public class Funcion {
	
	@Id
	@Column(name="idFuncion")
	private int idFuncion;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^([0-9]{4}[-][0-9]{2}[-][0-9]{2})$")
	@Column(name="fecha")
	private String fecha;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^(2[0-3]|[01]?[0-9]):([0-5]?[0-9])$")
	@Column(name="hora")
	private String hora;
	
	
	@NotNull
	@Column(name="idPelicula")
	private int idPelicula;

	
	@NotNull
	@Max(3)
	@Min(1)	
	@Column(name="idSala")
	private int idSala;
	
	
	@NotNull		
	@Column(name="costoBoleto")
	private float costoBoleto;
	
	@NotNull	
	@Column(name="estado")
	@Enumerated(EnumType.STRING)
	private estadoFuncion estado;
	
	
	/**
	 * @return the idFuncion
	 */
	public int getIdFuncion() {
		return idFuncion;
	}
	/**
	 * @param idFuncion the idFuncion to set
	 */
	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}
	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}
	/**
	 * @return the idPelicula
	 */
	public int getIdPelicula() {
		return idPelicula;
	}
	/**
	 * @param idPelicula the idPelicula to set
	 */
	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
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
	/**
	 * @return the costoBoleto
	 */
	public float getCostoBoleto() {
		return costoBoleto;
	}
	/**
	 * @param costoBoleto the costoBoleto to set
	 */
	public void setCostoBoleto(float costoBoleto) {
		this.costoBoleto = costoBoleto;
	}
	/**
	 * @return the estado
	 */
	public estadoFuncion getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(estadoFuncion estado) {
		this.estado = estado;
	}

	
	
}
