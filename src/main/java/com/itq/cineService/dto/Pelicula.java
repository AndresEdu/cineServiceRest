/**
 * 
 */
package com.itq.cineService.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author edugo
 *
 */
public class Pelicula {
	
	@NotEmpty
	@NotNull
	private int idPelicula;
	
	@NotEmpty
	@NotNull
	private String nombre;
	
	@NotEmpty
	@NotNull
	@Max(200)
	@Min(60)	
	private int duracion;
	
	@NotEmpty
	@NotNull
	private String clasificacion;
	
	@NotEmpty
	@NotNull
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
	public String getClasificacion() {
		return clasificacion;
	}
	/**
	 * @param clasificacion the clasificacion to set
	 */
	public void setClasificacion(String clasificacion) {
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
