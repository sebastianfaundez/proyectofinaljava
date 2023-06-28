package tech.curso.usuariosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.curso.usuariosapi.models.Telefono;


import java.io.Serializable;

@Repository("telefonoRepository")
public interface TelefonoRepository extends JpaRepository<Telefono, Serializable> {
}
