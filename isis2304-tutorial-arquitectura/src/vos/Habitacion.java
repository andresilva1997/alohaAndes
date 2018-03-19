package vos;

import org.codehaus.jackson.annotate.*;

public class Habitacion {
	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	/**
	 * tipo de cuarto ej. suite, double, single.
	 */
	@JsonProperty(value = "tipo")
	private String tipo;

	/**
	 * Cupo de personas que caben en la habitacion
	 */
	@JsonProperty(value = "cupo")
	private Integer cupo;

	/**
	 * Precio de habitacion por unidad minima de tiempo especificada por reglas
	 * de negocio y tipo operador.
	 */
	@JsonProperty(value = "precio")
	private Double precio;

	/**
	 * ubicacion de la habitacion.
	 */
	@JsonProperty(value = "ubicacion")
	private String ubicacion;

	/**
	 * Hay o no menaje en la habitacion
	 */
	@JsonProperty(value = "menaje")
	private Boolean menaje;

	@JsonProperty(value = "idOperador")
	private Long idOperador;

	@JsonProperty(value = "idHabitacion")
	private Long idHabitacion;
	
	@JsonProperty(value = "numero")
	private Integer numero;
	
	@JsonProperty(value = "ocupado")
	private Boolean ocupado;

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////

	/**
	 * Metodo constructor para la clase habitacion <b> post: </b> Crea la
	 * habitacion con los valores por parametros.
	 * 
	 * @param tipo
	 * @param cupo
	 * @param precio
	 * @param ubicacion
	 * @param menaje
	 * @param idOperador
	 * @param idHabitacion
	 * @param numero
	 */
	public Habitacion(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "idHabitacion") Long idHabitacion, @JsonProperty(value = "tipo") String tipo,
			@JsonProperty(value = "cupo") Integer cupo, @JsonProperty(value = "precio") Double precio,
			@JsonProperty(value = "ubicacion") String ubicacion, @JsonProperty(value = "numero") Integer numero, @JsonProperty(value = "menaje") Boolean menaje,
			@JsonProperty(value = "ocupado") Boolean ocupado) {
		this.tipo = tipo;
		this.cupo = cupo;
		this.precio = precio;
		this.ubicacion = ubicacion;
		this.menaje = menaje;
		this.idOperador = idOperador;
		this.idHabitacion = idHabitacion;
		this.numero = numero;
		this.ocupado = ocupado;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the cupo
	 */
	public Integer getCupo() {
		return cupo;
	}

	/**
	 * @param cupo
	 *            the cupo to set
	 */
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
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
	 * @return the numero
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return the idOperador
	 */
	public Long getIdOperador() {
		return idOperador;
	}

	/**
	 * @return the ocupado
	 */
	public Boolean getOcupado() {
		return ocupado;
	}

	/**
	 * @param ocupado the ocupado to set
	 */
	public void setOcupado(Boolean ocupado) {
		this.ocupado = ocupado;
	}

	/**
	 * @param idOperador the idOperador to set
	 */
	public void setIdOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the idHabitacion
	 */
	public Long getIdHabitacion() {
		return idHabitacion;
	}

	/**
	 * @param idHabitacion the idHabitacion to set
	 */
	public void setIdHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/**
	 * @param menaje
	 *            the menaje to set
	 */
	public void setMenaje(Boolean menaje) {
		this.menaje = menaje;
	}

}
