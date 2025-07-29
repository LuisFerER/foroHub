package com.blacklotuzz.forohub.domain.topico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosRegistroTopico(
        @NotNull
        Long idUsuario,
        @NotNull
        String mensaje,
        @NotNull
        String nombreCurso,
        @NotNull
        String titulo
) {
}
