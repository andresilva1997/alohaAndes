package vos;

import org.codehaus.jackson.annotate.*;

public class PersonaNatural extends Operador {

	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	@JsonProperty(value = "costoServicios")
	private Double costoServicios;

	@JsonProperty(value = "banhoCompartido")
	private Boolean banhoCompartido;

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////

	/**
	 * @param idOperador
	 * @param cupoTotal
	 * @param correo
	 * @param nombre
	 * @param costoServicios
	 * @param banhoCompartido
	 */
	public PersonaNatural(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre,@JsonProperty(value="tipo") String tipo,
			@JsonProperty(value = "costoServicios") Double costoServicios,
			@JsonProperty(value = "banhoCompartido") Boolean banhoCompartido) {
		super(idOperador, cupoTotal, correo, nombre,tipo);
		this.costoServicios = costoServicios;
		this.banhoCompartido = banhoCompartido;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the costoServicios
	 */
	public Double getCostoServicios() {
		return costoServicios;
	}

	/**
	 * @param costoServicios
	 *            the costoServicios to set
	 */
	public void setCostoServicios(Double costoServicios) {
		this.costoServicios = costoServicios;
	}

	/**
	 * @return the banhoCompartido
	 */
	public Boolean getBanhoCompartido() {
		return banhoCompartido;
	}

	/**
	 * @param banhoCompartido
	 *            the banhoCompartido to set
	 */
	public void setBanhoCompartido(Boolean banhoCompartido) {
		this.banhoCompartido = banhoCompartido;
	}

}
