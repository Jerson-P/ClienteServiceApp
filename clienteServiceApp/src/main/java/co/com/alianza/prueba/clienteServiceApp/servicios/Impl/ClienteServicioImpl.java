package co.com.alianza.prueba.clienteServiceApp.servicios.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import co.com.alianza.prueba.clienteServiceApp.dtos.ClienteDTO;
import co.com.alianza.prueba.clienteServiceApp.dtos.RespuestaDTO;
import co.com.alianza.prueba.clienteServiceApp.entidades.ClienteEntidad;
import co.com.alianza.prueba.clienteServiceApp.mapper.generales.ClienteMapper;
import co.com.alianza.prueba.clienteServiceApp.repositorios.ClienteRepositorio;
import co.com.alianza.prueba.clienteServiceApp.servicios.IClienteServicio;
import co.com.alianza.prueba.clienteServiceApp.utilidades.MensajesRespuestas;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteServicioImpl implements IClienteServicio {
	
	private final ClienteRepositorio clienteRepositorio;
	
	@Override
	public ResponseEntity<RespuestaDTO> buscarPorClaveCompartida(Integer claveCompartida) {

		Optional<ClienteEntidad> clienteOptional = clienteRepositorio.findById(claveCompartida);

		RespuestaDTO respuestaDTO;
		if (clienteOptional.isPresent()) {
			List<ClienteDTO> clientes = new ArrayList<>();
			clientes.add(ClienteMapper.INSTANCE.entidadADto(clienteOptional.get()));

			respuestaDTO = RespuestaDTO.builder().success(true).message(MensajesRespuestas.CONSULTA_EXITOSA)
					.code(HttpStatus.OK.value()).response(clientes).build();
		} else {
			respuestaDTO = RespuestaDTO.builder().code(HttpStatus.NOT_FOUND.value())
					.message("Servicios de clientes no encontrados para el Id: " + claveCompartida).response(null).build();
		}

		return ResponseEntity.status(respuestaDTO.getCode()).body(respuestaDTO);
	}

	@Override
	public ResponseEntity<RespuestaDTO> buscarTodos() {
		
		RespuestaDTO respuestaDTO;
		try {

			respuestaDTO = RespuestaDTO.builder().success(true).message(MensajesRespuestas.CONSULTA_EXITOSA)
					.code(HttpStatus.OK.value())
					.response(ClienteMapper.INSTANCE.listaBeanAListaDto(this.clienteRepositorio.findAll()))
					.build();

			return ResponseEntity.status(respuestaDTO.getCode()).body(respuestaDTO);

		} catch (Exception e) {

			respuestaDTO = RespuestaDTO.builder().success(false).message(MensajesRespuestas.CONSULTA_ERROR)
					.code(HttpStatus.BAD_REQUEST.value()).response(MensajesRespuestas.NINGUN_REGISTRO_ENCONTRADO).build();

		}
		return ResponseEntity.status(respuestaDTO.getCode()).body(respuestaDTO);
	}

	@Override
	public ResponseEntity<RespuestaDTO> guardarCliente(ClienteDTO clienteDTO) {
		try {

			clienteRepositorio.save(ClienteMapper.INSTANCE.dtoAEntidad(clienteDTO));

			RespuestaDTO respuestaDTO = RespuestaDTO.builder().success(true).message(MensajesRespuestas.GUARDADO_EXITOSO)
					.code(HttpStatus.CREATED.value()).build();

			return ResponseEntity.status(respuestaDTO.getCode()).body(respuestaDTO);
			
		} catch (Exception e) {

			return new ResponseEntity<>(RespuestaDTO.builder().success(false).message(e.getLocalizedMessage())
					.code(HttpStatus.BAD_REQUEST.value()).build(), HttpStatus.BAD_REQUEST);

		}
	}
	

}
