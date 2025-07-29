package com.blacklotuzz.forohub.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotNull
        Long id,
        String mensaje,
        String titulo,
        Boolean activo
) {

}
