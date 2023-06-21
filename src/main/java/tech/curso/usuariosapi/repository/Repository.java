package tech.curso.usuariosapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.curso.usuariosapi.models.Usuario;

public interface Repository extends JpaRepository<Usuario, String> {
}
