package org.unicentro.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unicentro.domain.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);
}
