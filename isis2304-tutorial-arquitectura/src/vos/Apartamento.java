package vos;

import org.codehaus.jackson.annotate.*;

public class Apartamento extends Operador {

	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	/**
	 * es o no amoblado el apto
	 */
	@JsonProperty(value = "amoblado")
	private Boolean amoblado;

	/**
	 * incluye o no servicioPublico
	 */
	@JsonProperty(value = "servicioPublico")
	private Boolean servicioPublico;

	/**
	 * incluye o no administracion
	 */
	@JsonProperty(value = "administracion")
	private Boolean administracion;

	/**
	 * tiene o no tv
	 */
	@JsonProperty(value = "tv")
	private Boolean tv;

	/**
	 * tiene o no internet
	 */
	@JsonProperty(value = "internet")
	private Boolean internet;



	/**
	 * precio por mes.
	 */
	@JsonProperty(value = "precio")
	private Double precio;

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////

	/**
	 * 
	 * @param idOperador
	 * @param cupoTotal
	 * @param correo
	 * @param nombre
	 * @param amoblado
	 * @param servicioPublico
	 * @param administracion
	 * @param tv
	 * @param internet
	 * @param propietario
	 * @param precio
	 */
	public Apartamento(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre,@JsonProperty(value="tipo") String tipo, @JsonProperty(value = "amoblado") Boolean amoblado,
			@JsonProperty(value = "servicioPublico") Boolean servicioPublico,
			@JsonProperty(value = "administracion") Boolean administracion, @JsonProperty(value = "tv") Boolean tv,
			@JsonProperty(value = "internet") Boolean internet, @JsonProperty(value = "precio") Double precio) {
		super(idOperador, cupoTotal, correo, nombre, tipo);
		this.amoblado = amoblado;
		this.servicioPublico = servicioPublico;
		this.administracion = administracion;
		this.tv = tv;
		this.internet = internet;
		this.precio = precio;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////
	/**
	 * @return the amoblado
	 */
	public Boolean getAmoblado() {
		return amoblado;
	}

	/**
	 * @param amoblado
	 *            the amoblado to set
	 */
	public void setAmoblado(Boolean amoblado) {
		this.amoblado = amoblado;
	}

	/**
	 * @return the servicioPublico
	 */
	public Boolean getServicioPublico() {
		return servicioPublico;
	}

	/**
	 * @param servicioPublico
	 *            the servicioPublico to set
	 */
	public void setServicioPublico(Boolean servicioPublico) {
		this.servicioPublico = servicioPublico;
	}

	/**
	 * @return the administracion
	 */
	public Boolean getAdministracion() {
		return administracion;
	}

	/**
	 * @param administracion
	 *            the administracion to set
	 */
	public void setAdministracion(Boolean administracion) {
		this.administracion = administracion;
	}

	/**
	 * @return the tv
	 */
	public Boolean getTv() {
		return tv;
	}

	/**
	 * @param tv
	 *            the tv to set
	 */
	public void setTv(Boolean tv) {
		this.tv = tv;
	}

	/**
	 * @return the internet
	 */
	public Boolean getInternet() {
		return internet;
	}

	/**
	 * @param internet
	 *            the internet to set
	 */
	public void setInternet(Boolean internet) {
		this.internet = internet;
	}

	

	/**
	 * @return the precio
	 */
	public Double getPrecio() {
		return precio;
	}

	/**
	 * @param precio
	 *            the precio to set
	 */
	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
