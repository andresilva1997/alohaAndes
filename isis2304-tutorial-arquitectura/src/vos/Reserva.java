package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.*;

public class Reserva {
	////////////////////////////////////////////
	//////////////// ATRIBUTOS///////////////////
	////////////////////////////////////////////

	/**
	 * Fecha y hora en la que se efectuo la reserva.
	 */
	@JsonProperty(value = "fechaInicio")
	private Date fechaInicio;

	/**
	 * Cancelado, booleano que especifica si ha sido cancelada la reserva
	 */
	@JsonProperty(value = "cancelado")
	private boolean cancelado;

	/**
	 * idUsuario del usuario que efectuo la reserva
	 */
	@JsonProperty(value = "idUsuario")
	private Long idUsuario;

	/**
	 * idOperador del operador ofreciendo el servicio
	 */
	@JsonProperty(value = "idOperador")
	private Long idOperador;

	/**
	 * idHabitacion reservado por el usuario
	 */
	@JsonProperty(value = "idHabitacion")
	private Long idHabitacion;

	/**
	 * Valor a pagar por la reserva
	 */
	@JsonProperty(value = "precio")
	private Double precio;

	/**
	 * Id unico de la reserva
	 */
	@JsonProperty(value = "idReserva")
	private Long idReserva;
	
	@JsonProperty(value = "fechaFinal") 
	private Date fechaFinal;

	
	
	

	////////////////////////////////////////////
	//////////////// CONSTRUCTOR/////////////////
	////////////////////////////////////////////

	/**
	 * Metodo constructor de la clase Reserva <b> post: </b> Crea la reserva con
	 * los valores por parametro.
	 * 
	 * @param fechaInicio
	 * @param cancelado2
	 * @param idUsuario
	 * @param idOperador
	 * @param idHabitacion
	 * @param idReserva
	 */
	public Reserva(@JsonProperty(value = "idReserva") Long idReserva, 
			@JsonProperty(value = "idUsuario") Long idUsuario,
			@JsonProperty(value = "idOperador") Long idOperador,
			@JsonProperty(value = "cancelado") boolean cancelado2,
			@JsonProperty(value = "precio") Double precio,
			@JsonProperty(value = "idHabitacion") Long idHabitacion,
			@JsonProperty(value = "fechaInicio") Date fechaInicio,
			@JsonProperty(value = "fechaInicio") Date fechaFinal) {
		this.fechaFinal = fechaFinal;
		this.idReserva = idReserva;
		this.fechaInicio = fechaInicio;
		this.cancelado = cancelado2;
		this.idUsuario = idUsuario;
		this.idOperador = idOperador;
		this.idHabitacion = idHabitacion;
		this.precio = precio;
	}

	////////////////////////////////////////////
	//////////// GETTERS AND SETTERS/////////////
	////////////////////////////////////////////

	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio
	 *            the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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
	 * @return the cancelado
	 */
	public boolean getCancelado() {
		return cancelado;
	}

	/**
	 * @param cancelado
	 *            the cancelado to set
	 */
	public void setCancelado(boolean cancelado) {
		this.cancelado = cancelado;
	}

	/**
	 * @return the idUsuario
	 */
	public Long getidUsuario() {
		return idUsuario;
	}

	/**
	 * @param idUsuario
	 *            the idUsuario to set
	 */
	public void setidUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idOperador
	 */
	public Long getidOperador() {
		return idOperador;
	}

	/**
	 * @param idOperador
	 *            the idOperador to set
	 */
	public void setidOperador(Long idOperador) {
		this.idOperador = idOperador;
	}

	/**
	 * @return the idHabitacion
	 */
	public Long getidHabitacion() {
		return idHabitacion;
	}

	/**
	 * @param idHabitacion
	 *            the idHabitacion to set
	 */
	public void setidHabitacion(Long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	/**
	 * @return the idReserva
	 */
	public Long getIdReserva() {
		return idReserva;
	}

	/**
	 * @param idReserva
	 *            the idReserva to set
	 */
	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
