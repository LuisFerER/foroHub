package com.blacklotuzz.forohub.controller;

import com.blacklotuzz.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private RegistroDeTopicos registro;

    @Autowired
    private TopicoRepository topicoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity registrar(@RequestBody @Valid DatosRegistroTopico datos){

        var detalleTopico = registro.registrar(datos);

        return ResponseEntity.ok(detalleTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosDetalleTopico>> listar(@PageableDefault(size=10, sort={"fecha"}) Pageable paginacion){
        var page =  topicoRepository.findAllByActivoTrue(paginacion)
                .map(DatosDetalleTopico::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){

        var detalleTopico = registro.detallar(id);

        return ResponseEntity.ok(detalleTopico);
    }

    @Transactional
    @PutMapping
    public ResponseEntity actualizar(@RequestBody @Valid DatosActualizacionTopico datos){

        var detalleTopico = registro.actualizar(datos);

        return ResponseEntity.ok(detalleTopico);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminar(@PathVariable Long id){

        registro.eliminar(id);

        return ResponseEntity.noContent().build();
    }
}
