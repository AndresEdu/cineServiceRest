/**
 * 
 */
package com.itq.cineService.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 *
 *<xs:element name="funcionCreator">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="Funcion" type="tns:Funcion" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	
	<xs:element name="funcionReader">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="idFuncion" type="xs:int" />
			</xs:sequence>
		</xs:complexType>
	</xs:element>
	
	<xs:element name="estadoFuncion">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="idFuncion" type="xs:int" />
				<xs:element name="estado">
					<xs:simpleType>
						<xs:restriction base="xs:string">
							<xs:enumeration value="disponible" />
							<xs:enumeration value="llena" />
						</xs:restriction>
					</xs:simpleType>
				</xs:element>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
 */

@Entity()
@Table(name = "Funcion")
public class Funcion {
	
	@Id
	@Column(name="idFuncion")
	private int idFuncion;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = "^([0-9]{4}[-][0-9]{2}[-][0-9]{2})")
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
	
	@NotEmpty
	@NotNull	
	@Column(name="estado")
	private String estado;
	
	
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
