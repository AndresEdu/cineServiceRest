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
 *
 *<xs:element name="salaReader">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="idSala" type="xs:int" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>

	<xs:element name="salaCreator">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="Sala" type="tns:Sala" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	
 */
public class Sala {

	@NotEmpty
	@NotNull
	@Max(3)
	@Min(1)
	private int idSala;
	
	@NotEmpty
	@NotNull
	@Max(10)
	@Min(1)	
	private int cantFilas;
	
	@NotEmpty
	@NotNull
	@Max(10)
	@Min(1)	
	private int cantColumnas;
	
	@NotEmpty
	@NotNull
	private String estado;
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
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
