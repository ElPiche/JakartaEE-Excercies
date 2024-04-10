package api;

import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Tag(name="Esta página describe la API de servicio de mensajes")
@ApplicationScoped
@Path("/mensajes")
public class MensajeriaAPI {

	@Inject
	private Buzon buzon;
	
	//curl -X POST http://localhost:8080/02_jakartaRESTful_swagger/api/mensajes -H "Content-Type: application/json" -d '{"fecha":"2024-03-31T13:26:13.534Z[UTC]","mensaje":"hola"}'
	
	@Operation(summary = "Agregar un mensaje", description = "Agrega un nuevo mensaje en el buzon")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "El mensaje se agrego con exito"),
			@ApiResponse(responseCode = "404", description = "Ocurrio un error")
	})
	@Parameter(
		    description = "Mensaje a agregar",
		    example = "Hola",
		    name = "mensaje",
		    required = true, 
		    schema = @Schema(type = "string") // 
		    )
	@Parameter(
	    description = "Fecha del mensaje",
	    example = "2024-03-31T13:26:13.534Z[UTC]",
	    name = "fecha",
	    required = true, 
	    schema = @Schema(type = "string", format = "date-time") 
	    )

	@POST 
	@Produces (MediaType.APPLICATION_JSON)
	public void enviarMensaje(@Parameter(description = "Mensaje a agregar", example = "Hola", schema = @Schema(type = "string")) String mensaje, Date fecha) {
		System.out.println("Mensaje agregado ");
		buzon.agregar(mensaje);
	}
	
	
	//curl -X POST http://localhost:8080/02_jakartaRESTful_swagger/api/mensajes 
	@Operation(summary = "Lista de mensajes", description = "Devuelve una lista con todos los mensajes")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description = "Se retorna lista"),
			@ApiResponse(responseCode = "404", description = "Ocurrio un error, no devuelve nada")
	})
	@GET 
	@Produces (MediaType.APPLICATION_JSON)
	public List<Mensaje> listar() {
		System.out.println("Mensajes devueltos ");
		return buzon.listar();
	}
	
}
