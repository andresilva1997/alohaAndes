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
import vos.Reserva;
import vos.Usuario;

@Path("reservas")
public class ReservaService {
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
	 * Metodo GET que trae a todos los reservas en la Base de datos. <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del reserva <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/reservas <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON que contiene a todos los
	 *         reservas que estan en la Base de Datos <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReservas() {

		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			List<Reserva> reservas;
			reservas = tm.getAllReservas();
			return Response.status(200).entity(reservas).build();
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
	public Response getReservaById(@PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			Reserva usuario = tm.getReservaById(id);
			return Response.status(200).entity(usuario).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	/**
	 * Metodo GET que trae las reservas por usuario y operador en la Base de
	 * Datos con los ID dados por parametro <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido
	 * inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/usuarios/{id} <br/>
	 * 
	 * @return <b>Response Status 200</b> - JSON Reserva que contiene a la
	 *         reserva cuyo ID corresponda al parametro <br/>
	 *         <b>Response Status 500</b> - Excepcion durante el transcurso de
	 *         la transaccion
	 */
	@GET
	@Path("{idUsuario: \\d+}/{idOperador: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getReservaByUsuarioOperador(@PathParam("idUsuario") Long idUsuario,
			@PathParam("idOperador") Long idOperador) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			List<Reserva> usuarios;
			usuarios = tm.getReservaByUsuarioOperador(idUsuario, idOperador);
			return Response.status(200).entity(usuarios).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	/**
	 * crea una nueva reserva e informa de los posibles casos de error.
	 * 
	 * @param usuario
	 * @return
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response addReserva(Reserva reserva) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			tm.addReserva(reserva);
			return Response.status(200).entity(reserva).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	/**
	 * Modifica la reserva que entra por parametro e informa sobre los casos de
	 * error.
	 * 
	 * @param reserva
	 * @return
	 */
	@POST
	@Path("{id: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateReserva(Reserva reserva, @PathParam("id") Long id) {

		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if (tm.getReservaById(id) == null) {
				return Response.status(404).build();
			}
			tm.updateReserva(reserva);
			return Response.status(200).entity(reserva).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	/**
	 * Metodo que borra un usuario y comenta sobre los casos de error.
	 * 
	 * @param reserva
	 * @param codigo
	 * @return
	 */
	@DELETE
	@Path("{id: \\d+}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteReserva(Reserva reserva, @PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if (tm.getReservaById(id) == null) {
				return Response.status(404).build();
			}
			tm.deleteReserva(reserva);
			return Response.status(200).entity(reserva).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("RFC2")
	public Response RFC2() {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			List<String> res = tm.RFC2();
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("RFC1")
	public Response RFC1() {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			List<String> res = tm.RFC1();
			return Response.status(200).entity(res).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}

}
