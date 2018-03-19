package vos;

import org.codehaus.jackson.annotate.*;

public class Operador {

	////////////////////////////////////////////////////////////////////////
	///////////////////////////////ATRIBUTOS////////////////////////////////
	////////////////////////////////////////////////////////////////////////
	
	
	
	@JsonProperty(value="idOperador")
	private Long idOperador;
	
	@JsonProperty(value="cupoTotal")
	private Integer cupoTotal;
	
	@JsonProperty(value="correo")
	private String correo;
	
	@JsonProperty(value="nombre")
	private String nombre;
	
	@JsonProperty(value="tipo")
	private String tipo;
	
////////////////////////////////////////////
////////////////CONSTRUCTOR/////////////////
////////////////////////////////////////////
	
	
	/**
 * @param idOperador
 * @param cupoTotal
 * @param correo
 * @param nombre
 */
public Operador(@JsonProperty(value="idOperador") Long idOperador, @JsonProperty(value="cupoTotal") Integer cupoTotal, @JsonProperty(value="correo") String correo, @JsonProperty(value="nombre") String nombre, @JsonProperty(value="tipo") String tipo) {
	super();
	this.idOperador = idOperador;
	this.cupoTotal = cupoTotal;
	this.correo = correo;
	this.nombre = nombre;
	this.tipo = tipo;
}


////////////////////////////////////////////
////////////GETTERS AND SETTERS/////////////
////////////////////////////////////////////



	/**
	 * @return the idOperador
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the cupoTotal
	 */
	public Integer getCupoTotal() {
		return cupoTotal;
	}

	/**
	 * @param cupoTotal the cupoTotal to set
	 */
	public void setCupoTotal(Integer cupoTotal) {
		this.cupoTotal = cupoTotal;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
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
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}


	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	
}
