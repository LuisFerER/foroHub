package com.blacklotuzz.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

    Boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findAllByActivoTrue(Pageable paginacion);
}
