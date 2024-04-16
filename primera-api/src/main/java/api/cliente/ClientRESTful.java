package api.cliente;

import java.util.List;

import api.Empleado;
import api.Tarea;
import api.aplicacion.IControladorService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@ApplicationScoped
@Path("/empleados")
public class ClientRESTful {
	
	@Inject
	private IControladorService controlador;
	
	
	//formacion del link finalName(pom.xml)/urlPattern(web.xml)/Path
	
	/**
	 * curl -v http://localhost:8080/EmpleadosAPI/api/empleados
	 * @return
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Empleado> obtenerEmpleados() {
		System.out.println("Retornando todos los empleados");
		return controlador.listarEmpleados();
	}
	
	/**
	 * curl -v http://localhost:8080/EmpleadosAPI/api/empleados/2
	 * @param id
	 * @return
	 */
	@Path("/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Empleado getEmpleado(@PathParam("id") Integer id) {
		System.out.println("Buscando empleado especifico" + id);
		return controlador.obtenerEmpleado(id);
	}
	

	/**
	 * Peticion rol autorizado
	 * curl --cacert certificadoPrueba.pem --user gerente:1234 -v https://localhost:8443/EmpleadosAPI/api/empleados/gerente/tareaEmpleado/2
	 * 
	 * Peticion rol no autorizado
	 * curl --cacert certificadoPrueba.pem --user recursosHumanos:1234 -v https://localhost:8443/EmpleadosAPI/api/empleados/gerente/tareaEmpleado/2
	 * 
	 * 
	 * curl -v http://localhost:8080/EmpleadosAPI/api/empleados/tareaEmpleado/1
	 * @param id
	 * @return
	 */
	@Path("/gerente/tareaEmpleado/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Tarea> getTareasEmplead(@PathParam("id") Integer id) {
		System.out.println("Buscando tareas del empleado: " + id);
		return controlador.listaTareasEmpleado(id);
	}
	
	/**
	 *
	 * curl --user recursosHumanos:1234 -v http://localhost:8080/Build_api/api/empleados/recursosHumanos/
	 * Peticion rol autorizado
	 * 	 
	 * curl --cacert certificadoPrueba.pem --user recursosHumanos:1234 -v -X POST -H "Content-Type: application/json" -d '{"id":23,"nombre":"Messi","cedula":"123456789"}' https://localhost:8443/EmpleadosAPI/api/empleados/recursosHumanos/
	 * 
	 * Peticion rol no autorizado
	 * curl --cacert certificadoPrueba.pem --user gerente:1234 -v -X POST -H "Content-Type: application/json" -d '{"id":23,"nombre":"Messi","cedula":"123456789"}' https://localhost:8443/EmpleadosAPI/api/empleados/recursosHumanos/
	 * 
	 * curl -X POST -H "Content-Type: application/json" -d '{"id":1,"nombre":"Juan","cedula":"123456789"}' http://localhost:8080/EmpleadosAPI/api/empleados
	 * @param empleado
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON) //tenemos que indicar como viene formateada la información
	@Path("/recursosHumanos/")
	@Produces({MediaType.APPLICATION_JSON})
	public void crearEmpleado(Empleado empleado) {
		System.out.println("Creando nuevo empleado");
		controlador.agregarEmpleados(empleado.getId(), empleado.getNombre(), empleado.getCedula());
	}
	
	
	/**
	 * Peticion rol autorizado
	 *curl --cacert certificadoPrueba.pem --user gerente:1234 -v -X DELETE https://localhost:8443/EmpleadosAPI/api/empleados/recursosHumanos/2
	 *
	 *Peticion rol no autorizado
	 * curl --cacert certificadoPrueba.pem --user recursosHumanos:1234 -v -X DELETE https://localhost:8443/EmpleadosAPI/api/empleados/recursosHumanos/2
	 * 

	 * curl -X DELETE -H "Content-Type : application/json" -d '{"id" : 0 ,}' http://localhost:8080/EmpleadosAPI/api/empleados/1
	 * curl -X DELETE http://localhost:8080/EmpleadosAPI/api/empleados/0
	 * @param id
	 */
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/recursosHumanos/{id}") //
	public void eliminarEmpleado(@PathParam("id") Integer id) {
		System.out.println("Eliminando empleado" + id);
		controlador.borrarEmpleados(id);
	}
	
	//http://localhost:8080/EmpleadosAPI/api/empleados/asignarTarea?idEmpleado=1&idTarea=1
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/asignarTarea")
	public void asignarTarea(@QueryParam("idEmpleado") Integer idEmpleado, @QueryParam("idTarea") Integer idTarea) {
		System.out.println("Asignando tarea con id:" + idTarea + "Al empleado con id: " + idEmpleado);
		controlador.agregarTareaEmpleado(idEmpleado, idTarea);
	}
}
