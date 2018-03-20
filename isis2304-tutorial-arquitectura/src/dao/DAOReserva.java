package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.*;

public class DAOReserva {

	/////////////////////////
	//////// CONSTANTES///////
	/////////////////////////

	/**
	 * Constante para indicar el usuario Oracle
	 */
	public final static String USUARIO = "ISIS2304A311810";

	/////////////////////////
	//////// ATRIBUTOS////////
	/////////////////////////

	/**
	 * Arraylits de recursos que se usan para la ejecucion de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexion a la base de datos
	 */
	private Connection conn;

	///////////////////////////////////
	//// METODOS DE INICIALIZACION/////
	///////////////////////////////////

	/**
	 * Metodo constructor de la clase DAOReserva
	 */
	public DAOReserva() {
		recursos = new ArrayList<Object>();
	}

	////////////////////////////////////////
	///// METODOS DE CONEXION CON LA BD/////
	////////////////////////////////////////

	/**
	 * Metodo que obtiene la informacion de todos los reservas en la Base de Datos
	 * <br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @return lista con la informacion de todos los reservas que se encuentran en
	 *         la Base de Datos
	 * @throws SQLException
	 *             Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public ArrayList<Reserva> getReserva() throws SQLException, Exception {
		ArrayList<Reserva> reservas = new ArrayList<>();
		String sq1 = String.format("SELECT * FROM %s.RESERVAS", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			reservas.add(convertResultToReserva(rs));
		}
		return reservas;

	}

	/**
	 * Metodo que obtiene la informacion del reserva en la Base de Datos que tiene
	 * el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @param id
	 *            el identificador del reserva
	 * @return la informacion del reserva que cumple con los criterios de la
	 *         sentecia SQL Null si no existe el reserva conlos criterios
	 *         establecidos
	 * @throws SQLException
	 *             SQLException Genera excepcion si hay error en la conexion o en la
	 *             consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public Reserva findReservaById(Long id) throws SQLException, Exception {
		Reserva reserva = null;
		String sq1 = String.format("SELECT * FROM %1$s.RESERVAS WHERE ID_RESERVA = %2$d", USUARIO, id);

		PreparedStatement prepstmt = conn.prepareStatement(sq1);
		recursos.add(prepstmt);
		ResultSet rs = prepstmt.executeQuery();

		while (rs.next()) {
			reserva = convertResultToReserva(rs);
		}

		return reserva;
	}

	/**
	 * Metodo que encuentra las reservas por un usuario y un operador.
	 * 
	 * @throws SQLException
	 */
	public ArrayList<Reserva> findReservaByUsuarioOperador(Long codigo, Long opID) throws SQLException, Exception {
		ArrayList<Reserva> respu = new ArrayList<>();

		String sq1 = String.format("SELECT * FROM %1$s.RESERVAS WHERE CODIGOUNIANDINO = %2$d AND ID_OPERADOR = %3$d",
				USUARIO, codigo, opID);

		PreparedStatement prepstmt = conn.prepareStatement(sq1);
		recursos.add(prepstmt);
		ResultSet rs = prepstmt.executeQuery();

		while (rs.next()) {
			respu.add(convertResultToReserva(rs));
		}

		return respu;
	}

	/**
	 * Metodo que devuelve los operadores con sus nombres y la ganancia anual.
	 * 
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<String> RFC1() throws SQLException, Exception {
		ArrayList<String> respu = new ArrayList<>();

		StringBuilder sq1 = new StringBuilder();
		sq1.append("SELECT op.NOMBRE, re.ID_OPERADOR ID_OPERADOR, SUM(PRECIO) as GANANCIA_ANUAL");
		sq1.append(String.format(" FROM %1$s.RESERVAS re , %1$s.OPERADORES op", USUARIO));
		sq1.append(" WHERE re.FECHA_INICIAL > CURRENT_DATE - 800");
		sq1.append(" AND re.ID_OPERADOR = op.ID_OPERADOR");
		sq1.append(" GROUP BY re.ID_OPERADOR, op.NOMBRE");
		sq1.append(" ORDER BY GANANCIA_ANUAL DESC");

		System.out.println(sq1);

		PreparedStatement prepstmt = conn.prepareStatement(sq1.toString());
		recursos.add(prepstmt);
		ResultSet rs = prepstmt.executeQuery();

		while (rs.next()) {
			System.out.println(rs.toString() + "ARREGLAR ESTO PARA QUE SEA BONITO");
			respu.add(rs.toString());
		}
		System.out.println(respu);
		return respu;
	}

	/**
	 * MEtodo que encuentra las 20 ofertas mas populares basado en el historial de
	 * reservas pasadas.
	 * 
	 * @return Una lista de Strings que describen el operador y la habitacion mas
	 *         solicitada.
	 * @throws SQLException
	 * @throws Exception
	 */
	public ArrayList<String> RFC2() throws SQLException, Exception {
		ArrayList<String> respu = new ArrayList<>();

		StringBuilder sq1 = new StringBuilder();
		sq1.append("SELECT DISTINCT ID_OPERADOR, ID_HABITACION");
		sq1.append(String.format("FROM %s.RESERVAS", USUARIO));
		sq1.append("GROUP BY ID_OPERADOR, ID_HABITACION");
		sq1.append("ORDER BY COUNT(ID_OPERADOR) DESC");

		System.out.println(sq1);

		PreparedStatement prepstmt = conn.prepareStatement(sq1.toString());
		recursos.add(prepstmt);
		ResultSet rs = prepstmt.executeQuery();

		int i = 0;
		while (rs.next() && i <= 20) {
			System.out.println(rs.toString() + "ARREGLAR ESTO PARA QUE QUEDE BONITO");
			respu.add(rs.toString());
			i++;
		}

		return respu;
	}

	/**
	 * Metodo que agregar la informacion de una nueva reserva en la Base de Datos a
	 * partir del parametro ingresado<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @param Reserva
	 *            reserva que desea agregar a la Base de Datos
	 * @throws SQLException
	 *             SQLException Genera excepcion si hay error en la conexion o en la
	 *             consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public void addReserva(Reserva reserva) throws SQLException, Exception {
		char s1 = boolToInt(reserva.getCancelado());
		String sq1 = String.format(
				"INSERT INTO %1$s.RESERVAS (ID_RESERVA, CODIGOUNIANDINO, ID_OPERADOR, CANCELADO, PRECIO, ID_HABITACION, FECHA_INICIAL, FECHA_FINAL, HORA_CREACION) VALUES (%2$d, %3$d, %4$d, %5$c, %6$f, %7$d, TO_DATE('%8$tF', 'YYYY-MM-DD'), TO_DATE('%9$tF', 'YYYY-MM-DD'), CURRENT_TIMESTAMP)",
				USUARIO, reserva.getIdReserva(), reserva.getidUsuario(), reserva.getidOperador(), s1,
				reserva.getPrecio(), reserva.getidHabitacion(), reserva.getFechaInicio(), reserva.getFechaFinal());

		System.out.println(sq1);

		PreparedStatement prpstmt = conn.prepareStatement(sq1);
		recursos.add(prpstmt);
		prpstmt.executeQuery();
	}

	/**
	 * Metodo que actualiza la informacion del usuario en la Base de Datos que tiene
	 * el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @param usuario
	 *            usuario que desea actualizar a la Base de Datos
	 * @throws SQLException
	 *             SQLException Genera excepcion si hay error en la conexion o en la
	 *             consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public void updateReservas(Reserva reserva) throws SQLException, Exception {

		char s1 = boolToInt(reserva.getCancelado());
		StringBuilder sq1 = new StringBuilder();
		sq1.append(String.format("UPDATE %s.RESERVAS SET ", USUARIO));
		sq1.append(String.format("ID_RESERVA = %1$d, CODIGOUNIANDINO = %2$d, ID_OPERADOR = %3$d, CANCELADO = '%4$c', PRECIO = %5$f, ID_HABITACION = %6$d, FECHA_INICIAL = TO_DATE('%6$tF', 'YYYY-MM-DD'), FECHA_FINAL = TO_DATE('%7$tF', 'YYYY-MM-DD')",
				reserva.getIdReserva(), reserva.getidUsuario(), reserva.getidOperador(), s1, reserva.getPrecio(),
				reserva.getidHabitacion(), reserva.getFechaInicio(), reserva.getFechaFinal()));
		sq1.append(String.format("WHERE ID_RESERVA = %d ", reserva.getIdReserva()));

		System.out.println(sq1);
		
		
		
		PreparedStatement prepStmt = conn.prepareStatement(sq1.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	/**
	 * Metodo que actualiza la informacion del reserva en la Base de Datos que tiene
	 * el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @param reserva
	 *            reserva que desea actualizar a la Base de Datos
	 * @throws SQLException
	 *             SQLException Genera excepcion si hay error en la conexion o en la
	 *             consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public void deleteReserva(Reserva reserva) throws SQLException, Exception {
		String sq1 = String.format("DELETE FROM %1$s.RESERVAS WHERE ID_RESERVA = %2$d", USUARIO,
				reserva.getIdReserva());
		System.out.println(sq1);

		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	////////////////////////////////
	////// METODOS AUXILIARES////////
	////////////////////////////////

	public Reserva convertResultToReserva(ResultSet resultSet) throws SQLException {
		Long idReserva = resultSet.getLong("ID_RESERVA");
		Long codigoUsuario = resultSet.getLong("CODIGOUNIANDINO");
		Long idHabitacion = resultSet.getLong("ID_HABITACION");
		Long idOperador = resultSet.getLong("ID_OPERADOR");
		Double precio = resultSet.getDouble("PRECIO");
		Boolean cancelado = resultSet.getBoolean("CANCELADO");
		Date fechaInicial = resultSet.getDate("FECHA_INICIAL");
		Date fechaFinal = resultSet.getDate("FECHA_FINAL");
		Date horaCreacion = resultSet.getDate("HORA_CREACION");

		Reserva reserva = new Reserva(idReserva, codigoUsuario, idOperador, cancelado, precio, idHabitacion,
				fechaInicial, fechaFinal, horaCreacion);

		return reserva;
	}

	private char boolToInt(Boolean bol) {
		return bol ? '1' : '0';
	}

	/**
	 * Metodo encargado de inicializar la conexion del DAO a la Base de Datos a
	 * partir del parametro <br/>
	 * <b>Postcondicion: </b> el atributo conn es inicializado <br/>
	 * 
	 * @param connection
	 *            la conexion generada en el TransactionManager para la comunicacion
	 *            con la Base de Datos
	 */
	public void setConn(Connection connection) {
		this.conn = connection;
	}

	/**
	 * Metodo que cierra todos los recursos que se encuentran en el arreglo de
	 * recursos<br/>
	 * <b>Postcondicion: </b> Todos los recurso del arreglo de recursos han sido
	 * cerrados.
	 */
	public void cerrarRecursos() {
		for (Object ob : recursos) {
			if (ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

}
