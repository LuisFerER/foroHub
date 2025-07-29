package com.blacklotuzz.forohub.domain.topico;

import com.blacklotuzz.forohub.domain.ValidacionException;
import com.blacklotuzz.forohub.domain.curso.CursoRepository;
import com.blacklotuzz.forohub.domain.topico.validaciones.ValidadorRegistroTopicos;
import com.blacklotuzz.forohub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistroDeTopicos {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private List<ValidadorRegistroTopicos> validadoresRegistro;

    public DatosDetalleTopico registrar(DatosRegistroTopico datos) {

        if (!usuarioRepository.existsById(datos.idUsuario())){
            throw new ValidacionException("No existe un usuario con el id informado");
        }

        var curso = cursoRepository.findByNombre(datos.nombreCurso());
        if (curso == null){
            throw new ValidacionException("No existe un curso con el nombre asignado");
        }

        //Validaciones
        validadoresRegistro.forEach(v -> v.validar(datos));

        var usuario = usuarioRepository.findById(datos.idUsuario()).get();
        var fecha = LocalDateTime.now();
        var topico = new Topico(null, usuario, datos.mensaje(), curso, datos.titulo(), fecha, true);

        topicoRepository.save(topico);

        return new DatosDetalleTopico(topico);

    }

    public DatosDetalleTopico detallar(Long id) {

        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id asignado");
        }

        var topico = topicoRepository.getReferenceById(id);

        return new DatosDetalleTopico(topico);
    }

    public DatosDetalleTopico actualizar(DatosActualizacionTopico datos) {
        if (!topicoRepository.existsById(datos.id())) {
            throw new ValidacionException("No existe un topico con el id asignado");
        }

        //Validaciones
        validadoresRegistro.forEach(v -> v.validar(datos));

        var topico = topicoRepository.getReferenceById(datos.id());
        var fecha = LocalDateTime.now();

        topico.actualizarInformaciones(datos.mensaje(),datos.titulo(), fecha, datos.activo());

        return new DatosDetalleTopico(topico);
    }

    public void eliminar(Long id) {
        if (!topicoRepository.existsById(id)) {
            throw new ValidacionException("No existe un topico con el id asignado");
        }

        var topico = topicoRepository.getReferenceById(id);
        topico.eliminar();
    }
}
