package com.blacklotuzz.forohub.domain.topico.validaciones;

import com.blacklotuzz.forohub.domain.topico.DatosActualizacionTopico;
import com.blacklotuzz.forohub.domain.topico.DatosRegistroTopico;

public interface ValidadorRegistroTopicos {
    void validar(DatosRegistroTopico datos);
    void validar(DatosActualizacionTopico datos);
}
