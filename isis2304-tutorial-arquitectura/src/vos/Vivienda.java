package vos;

import org.codehaus.jackson.annotate.*;

public class Vivienda extends Operador {

	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	/**
	 * Numero de habitaciones en la vivienda
	 */
	@JsonProperty(value = "numeroDeHabitaciones")
	private Integer numeroDeHabitaciones;

	/**
	 * donde esta ubicada
	 */
	@JsonProperty(value = "ubicacion")
	private String ubicacion;

	/**
	 * Tiene o no menaje
	 */
	@JsonProperty(value = "menaje")
	private Boolean menaje;

	/**
	 * costo de alquilar la vivienda.
	 */
	@JsonProperty(value = "costo")
	private Double costo;

	/**
	 * Descripcion del seguro con costos y terminos y condiciones
	 */
	@JsonProperty(value = "seguro")
	private String seguro;

	/**
	 * Conteo de las veces que la propiedad ha sido alquilada en el corrido del
	 * anho
	 */
	@JsonProperty(value = "diasAlquilada")
	private Integer diasAlquilada;

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////

	/**
	 * @param idOperador
	 * @param cupoTotal
	 * @param correo
	 * @param nombre
	 * @param numeroDeHabitaciones
	 * @param ubicacion
	 * @param menaje
	 * @param costo
	 * @param seguro
	 * @param diasAlquilada
	 */
	public Vivienda(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre, @JsonProperty(value="tipo") String tipo,@JsonProperty(value = "numeroDeHabitaciones") Integer numeroDeHabitaciones,
			@JsonProperty(value = "ubicacion") String ubicacion,
			@JsonProperty(value = "menaje") Boolean menaje, @JsonProperty(value = "costo") Double costo, @JsonProperty(value = "seguro") String seguro,
			@JsonProperty(value = "diasAlquilada") Integer diasAlquilada) {
		super(idOperador, cupoTotal, correo, nombre,tipo);
		this.numeroDeHabitaciones = numeroDeHabitaciones;
		this.ubicacion = ubicacion;
		this.menaje = menaje;
		this.costo = costo;
		this.seguro = seguro;
		this.diasAlquilada = diasAlquilada;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the numeroDeHabitaciones
	 */
	public Integer getNumeroDeHabitaciones() {
		return numeroDeHabitaciones;
	}

	/**
	 * @param numeroDeHabitaciones
	 *            the numeroDeHabitaciones to set
	 */
	public void setNumeroDeHabitaciones(Integer numeroDeHabitaciones) {
		this.numeroDeHabitaciones = numeroDeHabitaciones;
	}

	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion
	 *            the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the menaje
	 */
	public Boolean getMenaje() {
		return menaje;
	}

	/**
	 * @param menaje
	 *            the menaje to set
	 */
	public void setMenaje(Boolean menaje) {
		this.menaje = menaje;
	}

	/**
	 * @return the costo
	 */
	public Double getCosto() {
		return costo;
	}

	/**
	 * @param costo
	 *            the costo to set
	 */
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	/**
	 * @return the seguro
	 */
	public String getSeguro() {
		return seguro;
	}

	/**
	 * @param seguro
	 *            the seguro to set
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	/**
	 * @return the diasAlquilada
	 */
	public Integer getDiasAlquilada() {
		return diasAlquilada;
	}

	/**
	 * @param diasAlquilada
	 *            the diasAlquilada to set
	 */
	public void setDiasAlquilada(Integer diasAlquilada) {
		this.diasAlquilada = diasAlquilada;
	}

}
