package vos;

import java.util.Date;
import org.codehaus.jackson.annotate.*;

public class Hostal extends Hotel {

	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	/**
	 * Hora de apertura de el hostal
	 */
	@JsonProperty(value = "horaApertura")
	private Integer horaApertura;

	/**
	 * Hora de cierre del hotel
	 */
	@JsonProperty(value = "horaCierre")
	private Integer horaCierre;

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
	 * @param recepcion247
	 * @param horaApertura
	 * @param horaCierre
	 */
	public Hostal(@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cupoTotal") Integer cupoTotal, @JsonProperty(value = "correo") String correo,
			@JsonProperty(value = "nombre") String nombre,@JsonProperty(value="tipo") String tipo, @JsonProperty(value = "restaurante") Boolean restaurante,
			@JsonProperty(value = "piscina") Boolean piscina, 
			@JsonProperty(value = "parqueadero") Boolean parqueadero, @JsonProperty(value = "wifi") Boolean wifi,
			@JsonProperty(value = "tvCable") Boolean tvCable,
			@JsonProperty(value = "horaApertura") Integer horaApertura,
			@JsonProperty(value = "horaCierre") Integer horaCierre, @JsonProperty(value="numRegistro") Long numRegisto, @JsonProperty(value="direccion")String direccion) {
		super(idOperador, cupoTotal, correo, nombre, tipo, restaurante, piscina, parqueadero, wifi, tvCable, numRegisto, direccion);
		this.horaApertura = horaApertura;
		this.horaCierre = horaCierre;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the horaApertura
	 */
	public Integer getHoraApertura() {
		return horaApertura;
	}

	/**
	 * @param horaApertura
	 *            the horaApertura to set
	 */
	public void setHoraApertura(Integer horaApertura) {
		this.horaApertura = horaApertura;
	}

	/**
	 * @return the horaCierre
	 */
	public Integer getHoraCierre() {
		return horaCierre;
	}

	/**
	 * @param horaCierre
	 *            the horaCierre to set
	 */
	public void setHoraCierre(Integer horaCierre) {
		this.horaCierre = horaCierre;
	}

}
