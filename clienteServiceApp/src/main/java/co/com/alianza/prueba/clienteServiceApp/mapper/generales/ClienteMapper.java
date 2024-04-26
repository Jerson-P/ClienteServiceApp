package co.com.alianza.prueba.clienteServiceApp.mapper.generales;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import co.com.alianza.prueba.clienteServiceApp.dtos.ClienteDTO;
import co.com.alianza.prueba.clienteServiceApp.entidades.ClienteEntidad;

@Mapper
public interface ClienteMapper {
	
	ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
	
	ClienteDTO entidadADto(ClienteEntidad entity);
	
	@InheritInverseConfiguration
	ClienteEntidad dtoAEntidad(ClienteDTO dto);
	
	List<ClienteDTO> listaBeanAListaDto(List<ClienteEntidad> list);

}
