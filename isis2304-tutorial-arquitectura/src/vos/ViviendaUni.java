package vos;

import org.codehaus.jackson.annotate.*;

public class ViviendaUni extends Operador {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "salasDeEstudioCosto")
	private Double salasDeEstudioCosto;

	@JsonProperty(value = "restauranteCosto")
	private Double restauranteCosto;

	@JsonProperty(value = "gimnasioCosto")
	private Double gimnasioCosto;

	@JsonProperty(value = "ubicacion")
	private String ubicacion;

	@JsonProperty(value = "capacidad")
	private Short capacidad;

	/**
	 * @param idOperador
	 * @param cupoTotal
	 * @param correo
	 * @param nombre
	 * @param id
	 * @param salasDeEstudioCosto
	 * @param restauranteCosto
	 * @param gimnasioCosto
	 * @param ubicacion
	 * @param capacidad
	 */
	public ViviendaUni(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre,@JsonProperty(value="tipo") String tipo,
			@JsonProperty(value = "salasDeEstudioCosto") Double salasDeEstudioCosto,
			@JsonProperty(value = "restauranteCosto") Double restauranteCosto,
			@JsonProperty(value = "gimansioCosto") Double gimnasioCosto,
			@JsonProperty(value = "ubicacion") String ubicacion, Short capacidad) {
		super(idOperador, cupoTotal, correo, nombre,tipo);
		this.salasDeEstudioCosto = salasDeEstudioCosto;
		this.restauranteCosto = restauranteCosto;
		this.gimnasioCosto = gimnasioCosto;
		this.ubicacion = ubicacion;
		this.capacidad = capacidad;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the salasDeEstudioCosto
	 */
	public Double getSalasDeEstudioCosto() {
		return salasDeEstudioCosto;
	}

	/**
	 * @param salasDeEstudioCosto
	 *            the salasDeEstudioCosto to set
	 */
	public void setSalasDeEstudioCosto(Double salasDeEstudioCosto) {
		this.salasDeEstudioCosto = salasDeEstudioCosto;
	}

	/**
	 * @return the restauranteCosto
	 */
	public Double getRestauranteCosto() {
		return restauranteCosto;
	}

	/**
	 * @param restauranteCosto
	 *            the restauranteCosto to set
	 */
	public void setRestauranteCosto(Double restauranteCosto) {
		this.restauranteCosto = restauranteCosto;
	}

	/**
	 * @return the gimnasioCosto
	 */
	public Double getGimnasioCosto() {
		return gimnasioCosto;
	}

	/**
	 * @param gimnasioCosto
	 *            the gimnasioCosto to set
	 */
	public void setGimnasioCosto(Double gimnasioCosto) {
		this.gimnasioCosto = gimnasioCosto;
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
	 * @return the capacidad
	 */
	public Short getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad
	 *            the capacidad to set
	 */
	public void setCapacidad(Short capacidad) {
		this.capacidad = capacidad;
	}

}
