package ejemplo01;

import ejemplo00.aplicacion.MensajeServicios;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@ApplicationScoped
@Path("/empleado")
public class MensajeEmpleadoAPI {
	
	@Inject
	private MensajeServicios servicio;
	
	//http
	//curl --user usr2:1234 -v http://localhost:8080/03a_JakartaEE-Authorization/mensajes/empleado/enviarMensaje?mensaje=HolaMundo
	@GET
	@Path("/enviarMensaje")
	//invocar este método
	@Produces({ MediaType.APPLICATION_JSON })
	public String enviarMensajeComoGerente(@QueryParam("mensaje") String mensaje) {
		return servicio.enviarMensajeComoEmpleado(mensaje);
	}
	
	//https
	//curl --cacert certificadoPrueba.pem --user usr1:1234 -v https://localhost:8443/03a_JakartaEE-Authorization/mensajes/empleado/enviarMensajeSeguro?mensaje=HolaMundo
	//curl --cacert certificadoPrueba.pem --user usr2:1234 -v https://localhost:8443/03a_JakartaEE-Authorization/mensajes/empleado/enviarMensajeSeguro?mensaje=HolaMundo
	@GET
	@Path("/enviarMensajeSeguro")
	//invocar este método
	@Produces({ MediaType.APPLICATION_JSON })
	public String enviarMensajeSeguro(@QueryParam("mensaje") String mensaje) {
		return servicio.enviarMensajeComoEmpleado(mensaje);
	}

}
