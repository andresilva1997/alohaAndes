package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vos.*;

public class DAOUsuario {

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

	/////////////////////////////////
	//// METODOS DE INICIALIZACION////
	/////////////////////////////////

	/**
	 * Metodo constructor de la clase DAOUsuario
	 */
	public DAOUsuario() {
		recursos = new ArrayList<Object>();
	}

	///////////////////////////////////////
	///// METODOS DE CONEXION CON LA BD/////
	///////////////////////////////////////

	/**
	 * Metodo que obtiene la informacion de todos los usuarios en la Base de
	 * Datos <br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @return lista con la informacion de todos los usuarios que se encuentran
	 *         en la Base de Datos
	 * @throws SQLException
	 *             Genera excepcion si hay error en la conexion o en la consulta
	 *             SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public ArrayList<Usuario> getUsuario() throws SQLException, Exception {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		String sq1 = String.format("SELECT * FROM %1$s.USUARIOS", USUARIO);

		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			usuarios.add(convertResultToUsuario(rs));
		}
		return usuarios;

	}

	/**
	 * Metodo que obtiene la informacion del usuario en la Base de Datos que
	 * tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>
	 * 
	 * @param id
	 *            el identificador del usuario
	 * @return la informacion del usuario que cumple con los criterios de la
	 *         sentecia SQL Null si no existe el usuario conlos criterios
	 *         establecidos
	 * @throws SQLException
	 *             SQLException Genera excepcion si hay error en la conexion o
	 *             en la consulta SQL
	 * @throws Exception
	 *             Si se genera un error dentro del metodo.
	 */
	public Usuario findUsuarioByCodigo(Long id) throws SQLException, Exception {
		Usuario usuario = null;
		String sq1 = String.format("SELECT * FROM %1$s.USUARIOS WHERE CODIGO = %2$d", USUARIO, id);

		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			usuario = convertResultToUsuario(rs);
		}
		return usuario;
	}

	
	/**
	 * Metodo que agregar la  informacion de un nuevo usuario en la Base de Datos a partir del parametro ingresado<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param usuario usuario que desea agregar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void addUsuario(Usuario usuario) throws SQLException, Exception {
		String sq1 = String.format("INSERT INTO %1$s.USUARIOS (CODIGO, NOMBRE, CORREO) VALUES (%2$d, %3$s, %4$s)", USUARIO, usuario.getCodigoUniandes(), usuario.getNombre(), usuario.getCorreo());
		
		System.out.println(sq1);
		
		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		prepStmt.executeQuery();

	}
	
	/**
	 * Metodo que actualiza la informacion del usuario en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param usuario usuario que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void updateUsuario(Usuario usuario) throws SQLException, Exception
	{
		StringBuilder sq1 = new StringBuilder();
		sq1.append(String.format("UPDATE %s.USUARIOS SET ", USUARIO));
		sq1.append(String.format("CODIGO  = '%1$d' AND NOMBRE = '%2$s' AND CORREO = '%3$s'", usuario.getCodigoUniandes(), usuario.getNombre(), usuario.getCorreo()));
		sq1.append(String.format("WHERE CODIGO = '%d'", usuario.getCodigoUniandes()));
		
		System.out.println(sq1);
		
		PreparedStatement prepStmt = conn.prepareStatement(sq1.toString());
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	/**
	 * Metodo que actualiza la informacion del usuario en la Base de Datos que tiene el identificador dado por parametro<br/>
	 * <b>Precondicion: </b> la conexion a sido inicializadoa <br/>  
	 * @param usuario usuario que desea actualizar a la Base de Datos
	 * @throws SQLException SQLException Genera excepcion si hay error en la conexion o en la consulta SQL
	 * @throws Exception Si se genera un error dentro del metodo.
	 */
	public void deleteUsuario(Usuario usuario) throws SQLException, Exception
	{
		String sq1 = String.format("DELETE FROM %1$s.USUARIOS WHERE CODIGO = %2$d",  USUARIO, usuario.getCodigoUniandes());
		
		System.out.println(sq1);
		
		PreparedStatement prepStmt = conn.prepareStatement(sq1);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	////////////////////////////////
	//////METODOS AUXILIARES////////
	////////////////////////////////
	
	public Usuario convertResultToUsuario(ResultSet resultSet) throws SQLException {
		Long codigo = resultSet.getLong("CODIGO");
		String nombre = resultSet.getString("NOMBRE");
		String correo = resultSet.getString("CORREO");

		Usuario usuario = new Usuario(codigo, nombre, correo);

		return usuario;
	}
	
	/**
	 * Metodo encargado de inicializar la conexion del DAO a la Base de Datos a partir del parametro <br/>
	 * <b>Postcondicion: </b> el atributo conn es inicializado <br/>
	 * @param connection la conexion generada en el TransactionManager para la comunicacion con la Base de Datos
	 */
	public void setConn(Connection connection){
		this.conn = connection;
	}
	
	/**
	 * Metodo que cierra todos los recursos que se encuentran en el arreglo de recursos<br/>
	 * <b>Postcondicion: </b> Todos los recurso del arreglo de recursos han sido cerrados.
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

}
