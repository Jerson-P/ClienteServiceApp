package co.com.alianza.prueba.clienteServiceApp.entidades;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntidad {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shared_key")
	private Integer claveCompartida;
	
	@Column(name = "business_id")
	private String idEmpresarial;
	
	@Column(name = "email")
    private String correo;

    @Column(name = "phone")
    private String telefono;

    @Column(name = "data_added")
    private Date fechaAgregada;
    
	@Column(name = "status", insertable = true, updatable = true)
	private Boolean estado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", insertable = false, updatable = false)
    @CreatedDate
    private Date fechaCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_update", insertable  = false, updatable = true)
    @LastModifiedDate
    private Date fechaActualización;
	

}
