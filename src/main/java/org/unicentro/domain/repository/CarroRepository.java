package org.unicentro.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.unicentro.domain.model.Carro;
import org.unicentro.domain.model.Usuario;

public interface CarroRepository extends JpaRepository<Carro, Long>{
    List<Carro> findByUsuario(Usuario usuario);
}
