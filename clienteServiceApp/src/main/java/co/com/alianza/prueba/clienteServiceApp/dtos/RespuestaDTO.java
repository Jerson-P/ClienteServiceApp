package co.com.alianza.prueba.clienteServiceApp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaDTO {
	
	private Boolean success;
	
	private String message;
	
	private Integer code;
	
	private Object response; 

}
