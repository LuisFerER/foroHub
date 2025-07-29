package com.blacklotuzz.forohub.domain.topico.validaciones;

import com.blacklotuzz.forohub.domain.ValidacionException;
import com.blacklotuzz.forohub.domain.topico.DatosActualizacionTopico;
import com.blacklotuzz.forohub.domain.topico.DatosRegistroTopico;
import com.blacklotuzz.forohub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorTopicoDuplicado implements ValidadorRegistroTopicos {

    @Autowired
    TopicoRepository topicoRepository;

    public void validar(DatosRegistroTopico datos){
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(),datos.mensaje());

        if (topicoDuplicado){
            throw new ValidacionException("No se permiten topicos duplicados: mismo Titulo y Mensaje.");
        }

    }

    @Override
    public void validar(DatosActualizacionTopico datos) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(datos.titulo(),datos.mensaje());

        if (topicoDuplicado){
            throw new ValidacionException("No se permiten topicos duplicados: mismo Titulo y Mensaje.");
        }
    }
}
