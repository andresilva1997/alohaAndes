
package rest;

import java.util.ArrayList;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import EstructurasAuxiliares.Pair;
import tm.AlohaTransactionManager;
import vos.Apartamento;
import vos.Habitacion;
import vos.Hostal;
import vos.Hotel;
import vos.Operador;
import vos.PersonaNatural;
import vos.Reserva;
import vos.Vivienda;
import vos.ViviendaUni;

@Path("operadores")
public class OperadorService {


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
	public Response getOperadores() {
		System.out.println("brevepa");
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());

			List<Operador> operadores;
			operadores = tm.getAllOperadores();
			return Response.status(200).entity(operadores).build();
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@GET
	@Path("{tipo}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getOperadoresByTipo(@PathParam("tipo") String tipo) {
		System.out.println("ALOHAMELA");
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			
			switch(tipo.toUpperCase()) {
			case "HOTEL":
				List<Object> list =  tm.getOperadorByTipo(tipo);
				List<Hotel> hoteles = new ArrayList<>();
				for(Object o:list) {
					hoteles.add((Hotel)o);
				}
				return Response.status(200).entity(hoteles).build();
			case "HOSTAL":
				List<Object> listHostales =  tm.getOperadorByTipo(tipo);
				List<Hostal> hostales = new ArrayList<>();
				for(Object o:listHostales) {
					hostales.add((Hostal)o);
				}
				return Response.status(200).entity(hostales).build();
			case "PERSONANATURAL":
				List<Object> listPersonaNatural =  tm.getOperadorByTipo(tipo);
				List<PersonaNatural> personasNaturales = new ArrayList<>();
				for(Object o:listPersonaNatural) {
					personasNaturales.add((PersonaNatural)o);
				}
				return Response.status(200).entity(personasNaturales).build();
			case "VIVIENDA":
				System.out.println("Entro");
				List<Object> listViviendas =  tm.getOperadorByTipo(tipo);
				List<Vivienda> viviendas = new ArrayList<>();
				for(Object o:listViviendas) {
					viviendas.add((Vivienda)o);
				}
				return Response.status(200).entity(viviendas).build();
			case "VIVIENDAUNI":
				List<Object> listViviendasUni =  tm.getOperadorByTipo(tipo);
				List<ViviendaUni> viviendasUni = new ArrayList<>();
				for(Object o:listViviendasUni) {
					viviendasUni.add((ViviendaUni)o);
				}
				return Response.status(200).entity(viviendasUni).build();
			case "APARTAMENTO":
				List<Object> listApartamentos =  tm.getOperadorByTipo(tipo);
				List<Apartamento> apartamentos = new ArrayList<>();
				for(Object o:listApartamentos) {
					apartamentos.add((Apartamento)o);
				}
				return Response.status(200).entity(apartamentos).build();
			default:
				return Response.status(404).entity(doErrorMessage(new Exception("No existe"))).build();
			
			}
		}catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@GET
	@Path("id/{id: \\d+}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getOperadorById(@PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			
			Pair pareja = tm.findOperadorById(id);
			String tipo = pareja.getString();
			switch(tipo.toUpperCase()) {
			case "HOTEL":
				Hotel hoteles = (Hotel)pareja.getObject();
				return Response.status(200).entity(hoteles).build();
			case "HOSTAL":
				Hostal hostales = (Hostal)pareja.getObject();
				return Response.status(200).entity(hostales).build();
			case "PERSONANATURAL":
				PersonaNatural personasNaturales = (PersonaNatural)pareja.getObject();
				return Response.status(200).entity(personasNaturales).build();
			case "VIVIENDA":
				Vivienda viviendas = (Vivienda)pareja.getObject();
				return Response.status(200).entity(viviendas).build();
			case "VIVIENDAUNI":
				ViviendaUni viviendasUni = (ViviendaUni)pareja.getObject();
				return Response.status(200).entity(viviendasUni).build();
			case "APARTAMENTO":
				Apartamento apartamentos = (Apartamento)pareja.getObject();
				return Response.status(200).entity(apartamentos).build();
			default:
				return Response.status(404).entity(doErrorMessage(new Exception("No existe"))).build();
			
			}
		}catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	@Path("{tipo: \\s+}")
	public Response addOperador(Object object,@PathParam("tipo") String tipo) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			tm.addOperador(object, tipo);
			switch(tipo.toUpperCase()) {
			case "HOTEL":
				Hotel hoteles = (Hotel)object;
				return Response.status(200).entity(hoteles).build();
			case "HOSTAL":
				Hostal hostales = (Hostal)object;
				return Response.status(200).entity(hostales).build();
			case "PERSONANATURAL":
				PersonaNatural personasNaturales = (PersonaNatural)object;
				return Response.status(200).entity(personasNaturales).build();
			case "VIVIENDA":
				Vivienda viviendas = (Vivienda)object;
				return Response.status(200).entity(viviendas).build();
			case "VIVIENDAUNI":
				ViviendaUni viviendasUni = (ViviendaUni)object;
				return Response.status(200).entity(viviendasUni).build();
			case "APARTAMENTO":
				Apartamento apartamentos = (Apartamento)object;
				return Response.status(200).entity(apartamentos).build();
			default:
				return Response.status(404).entity(doErrorMessage(new Exception("No existe"))).build();
			
			}
		} catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@POST
	@Path("{tipo: \\s+}/{id: \\d+}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public Response updateOperador(Object object, @PathParam("tipo") String tipo, @PathParam("id") Long id) {
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if(tm.findOperadorById(id)==null) {
				return Response.status(404).build();
			}
			tm.updateOperador(object, tipo);
			switch(tipo.toUpperCase()) {
			case "HOTEL":
				Hotel hoteles = (Hotel)object;
				return Response.status(200).entity(hoteles).build();
			case "HOSTAL":
				Hostal hostales = (Hostal)object;
				return Response.status(200).entity(hostales).build();
			case "PERSONANATURAL":
				PersonaNatural personasNaturales = (PersonaNatural)object;
				return Response.status(200).entity(personasNaturales).build();
			case "VIVIENDA":
				Vivienda viviendas = (Vivienda)object;
				return Response.status(200).entity(viviendas).build();
			case "VIVIENDAUNI":
				ViviendaUni viviendasUni = (ViviendaUni)object;
				return Response.status(200).entity(viviendasUni).build();
			case "APARTAMENTO":
				Apartamento apartamentos = (Apartamento)object;
				return Response.status(200).entity(apartamentos).build();
			default:
				return Response.status(404).entity(doErrorMessage(new Exception("No existe"))).build();
			
			}
		}catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteOperador(Operador operador, @PathParam("id") Long id) {
		System.out.println("hello");
		try {
			AlohaTransactionManager tm = new AlohaTransactionManager(getPath());
			if (tm.findOperadorById(id) == null) {
				return Response.status(404).build();
			}
			tm.deleteOperador(operador);
			
			return Response.status(200).entity(operador).build();
		}catch (Exception e) {
			return Response.status(500).entity(doErrorMessage(e)).build();
		}
	}
	
}
