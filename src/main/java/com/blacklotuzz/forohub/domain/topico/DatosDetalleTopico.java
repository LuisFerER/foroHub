package com.blacklotuzz.forohub.domain.topico;

import java.time.LocalDateTime;

public record DatosDetalleTopico(
        Long id,
        Long idUsuario,
        Long idCurso,
        String titulo,
        String mensaje,
        LocalDateTime fecha) {

    public DatosDetalleTopico(Topico topico){
        this(
                topico.getId(),
                topico.getUsuario().getId(),
                topico.getCurso().getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha()
        );
    }
}
