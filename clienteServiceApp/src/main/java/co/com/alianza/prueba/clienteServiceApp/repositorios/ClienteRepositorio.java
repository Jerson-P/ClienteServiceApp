package co.com.alianza.prueba.clienteServiceApp.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.alianza.prueba.clienteServiceApp.entidades.ClienteEntidad;

public interface ClienteRepositorio extends JpaRepository<ClienteEntidad, Integer> {

}
