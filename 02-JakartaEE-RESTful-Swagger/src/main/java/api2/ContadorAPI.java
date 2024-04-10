package api2;

import api2.aplicacion.ContadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name="Esta página describe el servicio de la API contador")
@ApplicationScoped
@Path("/contador")
public class ContadorAPI {

	@Inject
	private ContadorService contadorService;
	
	//curl -X POST http://localhost:8080/02_jakartaRESTful_swagger/api/contador
	@Operation(summary = "Incrementar", description = "Incrementa el contador en +1")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Contador incrementado"),
			@ApiResponse(responseCode = "404", description = "Ocurrio un error")
	})
	@POST 
	@Produces (MediaType.APPLICATION_JSON)
	public void incrementa() {
		System.out.println("Incrementando contador");
		int valor = contadorService.incrementar();
		System.out.println("Nuevo valor " + valor);
	}
	
	//curl -X PUT http://localhost:8080/02_jakartaRESTful_swagger/api/contador
	@Operation(summary = "Inicializar contador", description = "Inicializa el contador en 0")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Contador inicializado con exito"),
			@ApiResponse(responseCode = "404", description = "Ocurrio un error")
	})
	@PUT 
	@Produces (MediaType.APPLICATION_JSON)
	public void inicializar() {
		System.out.println("Inicializando contador.");
		contadorService.inicializar();
	}
	
}
