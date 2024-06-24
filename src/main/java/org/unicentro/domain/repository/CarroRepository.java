package org.unicentro.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unicentro.domain.model.Carro;
import org.unicentro.domain.model.Usuario;

public class CarroRepository extends JpaRepository<Carro, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM public.carro ")
    List<Carro> findByModelo(Carro carro);

    List<Carro> findByUsuario(Usuario usuario);
}
