package co.com.alianza.prueba.clienteServiceApp.servicios;

import org.springframework.http.ResponseEntity;

import co.com.alianza.prueba.clienteServiceApp.dtos.ClienteDTO;
import co.com.alianza.prueba.clienteServiceApp.dtos.RespuestaDTO;

public interface IClienteServicio {
	
	public ResponseEntity<RespuestaDTO> buscarPorClaveCompartida(Integer claveCompartida);
	
	public ResponseEntity<RespuestaDTO> buscarTodos();
	
    public ResponseEntity<RespuestaDTO> guardarCliente(ClienteDTO clienteDTO);
		
}
