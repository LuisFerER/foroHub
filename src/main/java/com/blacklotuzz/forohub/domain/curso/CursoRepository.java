package com.blacklotuzz.forohub.domain.curso;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNombre(@NotNull String nombreCurso);
}
