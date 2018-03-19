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
import vos.Usuario;

@Path("usuarios")
public class UsuariosService {
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
	 * Metodo GET que trae a todos los usuarios en la Base de datos. <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/usuarios <br/>
	 * @return	<b>Response Status 200</b> - JSON que contiene a todos los usuarios que estan en la Base de Datos <br/>
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */			
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getUsuarios() {
		
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			
			List<Usuario> usuarios;
			usuarios = tm.getAllUsuarios();
			return Response.status(200).entity(usuarios).build();
		} 
		catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo GET que trae al usuario en la Base de Datos con el ID dado por parametro <br/>
	 * <b>Precondicion: </b> el archivo <em>'conectionData'</em> ha sido inicializado con las credenciales del usuario <br/>
	 * <b>URL: </b> http://localhost:8080/Aloha/rest/usuarios/{id} <br/>
	 * @return	<b>Response Status 200</b> - JSON Usuario que contiene al usuario cuyo ID corresponda al parametro <br/>
	 * 			<b>Response Status 500</b> - Excepcion durante el transcurso de la transaccion
	 */
	@GET
	@Path( "{codigo: \\d+}" )
	@Produces( { MediaType.APPLICATION_JSON } )
	public Response getUsuarioByCodigo( @PathParam( "codigo" ) Long codigo )
	{
		try{
			AlohaTransactionManager tm = new AlohaTransactionManager( getPath( ) );
			
			Usuario usuario = tm.getUsuarioByCodigo( codigo );
			return Response.status( 200 ).entity( usuario ).build( );			
		}
		catch( Exception e )
		{
			return Response.status( 500 ).entity( doErrorMessage( e ) ).build( );
		}
	}
	
	/**
	 * crea un nuevo usuario e informa de los posibles casos de error.
	 * @param usuario
	 * @return
	 */
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response addUsuario(Usuario usuario)
	{
		try
		{
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			tm.addUsuario(usuario);
			return Response.status(200).entity(usuario).build();
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Modifica el usuario que entra por parametro e informa sobre los casos de error.
	 * @param usuario
	 * @return
	 */
	@POST
	@Path( "{codigo: \\d+}" )
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Response updateUsuario(Usuario usuario, @PathParam("codigo") Long codigo)
	{
		
		try
		{
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if(tm.getUsuarioByCodigo(codigo) == null)
			{
				return Response.status(404).build();
			}
			tm.updateUsuario(usuario);
			return Response.status(200).entity(usuario).build();
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	/**
	 * Metodo que borra un usuario y comenta sobre los casos de error.
	 * @param usuario
	 * @param codigo
	 * @return
	 */
	@DELETE
	@Path( "{codigo: \\d+}" )
	public Response deleteUsuario(@PathParam("codigo") Long codigo)
	{
		try
		{
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if(tm.getUsuarioByCodigo(codigo) == null)
			{
				return Response.status(404).build();
			}
			Usuario usuario = tm.getUsuarioByCodigo(codigo);
			tm.deleteUsuario(usuario);
			return Response.status(200).entity(usuario).build();
		}
		catch(Exception e)
		{
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	

}
