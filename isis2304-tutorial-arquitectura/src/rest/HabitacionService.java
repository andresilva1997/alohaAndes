package rest;

import java.util.List;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tm.AlohaTransactionManager;
import vos.Habitacion;
import vos.Reserva;

@Path("habitaciones")
public class HabitacionService {
	///////////////////////////////
	////////// ATRIBUTOS////////////
	///////////////////////////////

	/**
	 * Atributo que usa la anotacion @Context para tener el ServletContext de la
	 * conexion actual.
	 */
	@Context
	private ServletContext context;

	///////////////////////////////
	/// METODOS DE INICIALIZACION///
	///////////////////////////////

	/**
	 * Metodo que retorna el path de la carpeta WEB-INF/ConnectionData en el
	 * deploy actual dentro del servidor.
	 * 
	 * @return path de la carpeta WEB-INF/ConnectionData en el deploy actual.
	 */
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}

	private String doErrorMessage(Exception e) {
		return "{ \"ERROR\": \"" + e.getMessage() + "\"}";
	}

	///////////////////////////////
	/////// METODOS DE REST////////
	///////////////////////////////

	/**
	 * Metodo GET que trae a todos los habitacions en la Base de datos. <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del habitacion <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/habitacions <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON que contiene a todos los
	 *         habitacions que estan en la Base de Datos <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getHabitacions() {

		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			List<Habitacion> habitacions;
			habitacions = tm.getAllHabitaciones();
			return Response.status(200).entity(habitacions).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	
	/**
	 * Metodo GET que trae al usuario en la Base de Datos con el ID dado por
	 * parametro <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/usuarios/{id} <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON Reserva que contiene al usuario
	 *         cuyo ID corresponda al parametro <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Path("{id: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response findHabitacionById(@PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			Habitacion usuario = tm.getAllHabitacionesById(id);
			return Response.status(200).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo GET que trae las habitaciones disponibles en la Base de
	 * Datos <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/habitaciones/disponibles <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON Reserva que contiene a la
	 *         habitacion cuyo ID corresponda al parametro <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Path("disponibles")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getHabitacionesDisponibles() {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			List<Habitacion> usuarios;
			usuarios = tm.getAllHabitacionesDisponibles();
			return Response.status(200).entity(usuarios).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo GET que trae las habitaciones disponibles por operador en la Base de
	 * Datos <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/habitaciones/disponibles <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON Reserva que contiene a la
	 *         habitacion cuyo ID corresponda al parametro <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Path("disponibles/{id: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getHabitacionesDisponiblesOperador(@PathParam("id") Long id) 
	{
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			List<Habitacion> usuarios;
			usuarios = tm.getAllHabitacionesDisponiblesOperador(id);
			return Response.status(200).entity(usuarios).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * crea una nueva habitacion e informa de los posibles casos de error.
	 * 
	 * @param habitacion
	 * @return
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addHabitacion(Habitacion habitacion) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			tm.addHabitacion(habitacion);
			return Response.status(200).entity(habitacion).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Modifica la habitacion que entra por parametro e informa sobre los casos de
	 * error.
	 * 
	 * @param reserva
	 * @return
	 */
	@POST
	@Path("{id: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateHabitacion(Habitacion habitacion, @PathParam("id") Long id) {

		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if (tm.getAllHabitacionesById(id) == null) {
				return Response.status(404).build();
			}
			tm.updateHabitacion(habitacion);
			return Response.status(200).entity(habitacion).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo que borra una habitacion y comenta sobre los casos de error.
	 * 
	 * @param reserva
	 * @param codigo
	 * @return
	 */
	@DELETE
	@Path("{id: \\d+}")
	public Response deleteHabitacion(@PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if (tm.getReservaById(id) == null) {
				return Response.status(404).build();
			}
			Habitacion habitacion = tm.getAllHabitacionesById(id);
			tm.deleteHabitacion(habitacion);
			return Response.status(200).entity(habitacion).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	
}
