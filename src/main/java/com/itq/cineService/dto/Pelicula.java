/**
 * 
 */
package com.itq.cineService.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author edugo
 *
 */



@Entity()
@Table(name = "Pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue
	@Column(name="idPelicula")
	private int idPelicula;
	
	@NotEmpty
	@NotNull
	@Column(name="nombre")
	private String nombre;
	
	
	@NotNull
	@Max(200)
	@Min(60)	
	@Column(name="duracion")
	private int duracion;
	
	@NotNull
	@Column(name="clasificacion")
	@Enumerated(EnumType.STRING)
	private Clasificacion clasificacion;
	
	@NotEmpty
	@NotNull
	@Column(name="descripcion")
	private String descripcion;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * @return the clasificacion
	 */
	public Clasificacion getClasificacion() {
		return clasificacion;
	}
	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
