package co.com.alianza.prueba.clienteServiceApp.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.com.alianza.prueba.clienteServiceApp.dtos.ClienteDTO;
import co.com.alianza.prueba.clienteServiceApp.dtos.RespuestaDTO;
import co.com.alianza.prueba.clienteServiceApp.servicios.Impl.ClienteServicioImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/Cliente")
@Tag(name = "Cliente - Controller", description = "Controller encargado de gestionar las operaciones de los clientes.")
@CrossOrigin(origins = "*", methods = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST,
		RequestMethod.PUT })
@RequiredArgsConstructor
public class ClienteControlador {
	
	private final ClienteServicioImpl clienteServicioImpl;

	@Operation(summary = "Operación que permite consultar los clientes")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }), })
	@GetMapping("/todos")
	public ResponseEntity<RespuestaDTO> buscarTodosClientes() {
		return this.clienteServicioImpl.buscarTodos();
	}
	
	
	@Operation(summary = "Operación que permite consultar un cliente a partir de una clave compartida")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se consulta exitosamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }), })
	@GetMapping("/{claveCompartida}")
	public ResponseEntity<RespuestaDTO> buscarPorClaveCompartida(@PathVariable Integer claveCompartida) {
		return this.clienteServicioImpl.buscarPorClaveCompartida(claveCompartida);
	}
	
	@Operation(summary = "Operación que permite guardar un cliente")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Se ha guardado satisfactoriamente", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "400", description = "La petición no puede ser entendida por el servidor debido a errores de sintaxis, el cliente no debe repetirla no sin antes hacer modificaciones", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "404", description = "El recurso solicitado no puede ser encontrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }),
			@ApiResponse(responseCode = "500", description = "Se presento una condición inesperada que impidió completar la petición", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = RespuestaDTO.class)) }), })
	@PostMapping
	public ResponseEntity<RespuestaDTO> guardarCliente(@RequestBody ClienteDTO clienteDTO) {
		return this.clienteServicioImpl.guardarCliente(clienteDTO);
	}

}
