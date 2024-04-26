package co.com.alianza.prueba.clienteServiceApp.dtos;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer claveCompartida;
	
    private String idEmpresarial;
    
    private String correo;
    
    private String telefono;
    
    private Date fechaAgregada;
    
    private Boolean estado;
    

}
