package com.blacklotuzz.forohub.domain.topico;

import com.blacklotuzz.forohub.domain.curso.Curso;
import com.blacklotuzz.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha;
    private Boolean status;
    private Boolean activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;


    public Topico(Object o, Usuario usuario, @NotNull String mensaje, Curso curso, @NotNull String titulo, LocalDateTime fecha, Boolean activo) {
        this.usuario = usuario;
        this.mensaje = mensaje;
        this.curso = curso;
        this.titulo = titulo;
        this.fecha = fecha;
        this.status = true;
        this.activo = activo;
    }

    public void actualizarInformaciones(String mensaje, String titulo, LocalDateTime fecha, Boolean activo) {
        if (mensaje != null) {
            this.mensaje = mensaje;
        }
        if (titulo != null) {
            this.titulo = titulo;
        }
        if (fecha != null) {
            this.fecha = fecha;
        }
        if (activo != null) {
            this.activo = activo;
        }

    }

    public void eliminar() {
        this.activo = false;
    }
}
