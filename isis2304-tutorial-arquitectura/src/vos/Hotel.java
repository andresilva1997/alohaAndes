package vos;

import org.codehaus.jackson.annotate.*;

public class Hotel extends Operador {

	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	
	
	@JsonProperty(value = "restaurante")
	private Boolean restaurante;

	@JsonProperty(value = "piscina")
	private Boolean piscina;

	@JsonProperty(value = "parqueadero")
	private Boolean parqueadero;

	@JsonProperty(value = "wifi")
	private Boolean wifi;

	@JsonProperty(value = "tvCable")
	private Boolean tvCable;
	
	@JsonProperty(value = "numRegistro")
	private Long numRegisto;
	
	@JsonProperty(value = "direccion")
	private String direccion;
	

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////
	/**
	 * @param idOperador
	 * @param cupoTotal
	 * @param correo
	 * @param nombre
	 * @param restaurante
	 * @param piscina
	 * @param parqueadero
	 * @param wifi
	 * @param tvCable
	 */
	public Hotel(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre, @JsonProperty(value="tipo") String tipo,@JsonProperty(value = "restaurante") Boolean restaurante,
			@JsonProperty(value = "piscina") Boolean piscina,
			@JsonProperty(value = "parqueadero") Boolean parqueadero, @JsonProperty(value = "wifi") Boolean wifi,
			@JsonProperty(value = "tvCable") Boolean tvCable,	@JsonProperty(value = "numRegistro") Long numRegisto, @JsonProperty(value = "direccion")String direccion) {
		super(idOperador, cupoTotal, correo, nombre,tipo);
		this.restaurante = restaurante;
		this.piscina = piscina;
		this.parqueadero = parqueadero;
		this.wifi = wifi;
		this.tvCable = tvCable;
		this.numRegisto = numRegisto;
		this.direccion = direccion;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the numRegisto
	 */
	public Long getNumRegisto() {
		return numRegisto;
	}

	/**
	 * @param numRegisto the numRegisto to set
	 */
	public void setNumRegisto(Long numRegisto) {
		this.numRegisto = numRegisto;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the restaurante
	 */
	public Boolean getRestaurante() {
		return restaurante;
	}

	/**
	 * @param restaurante
	 *            the restaurante to set
	 */
	public void setRestaurante(Boolean restaurante) {
		this.restaurante = restaurante;
	}

	/**
	 * @return the piscina
	 */
	public Boolean getPiscina() {
		return piscina;
	}

	/**
	 * @param piscina
	 *            the piscina to set
	 */
	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}

	/**
	 * @return the parqueadero
	 */
	public Boolean getParqueadero() {
		return parqueadero;
	}

	/**
	 * @param parqueadero
	 *            the parqueadero to set
	 */
	public void setParqueadero(Boolean parqueadero) {
		this.parqueadero = parqueadero;
	}

	/**
	 * @return the wifi
	 */
	public Boolean getWifi() {
		return wifi;
	}

	/**
	 * @param wifi
	 *            the wifi to set
	 */
	public void setWifi(Boolean wifi) {
		this.wifi = wifi;
	}

	/**
	 * @return the tvCable
	 */
	public Boolean getTvCable() {
		return tvCable;
	}

	/**
	 * @param tvCable
	 *            the tvCable to set
	 */
	public void setTvCable(Boolean tvCable) {
		this.tvCable = tvCable;
	}

}
