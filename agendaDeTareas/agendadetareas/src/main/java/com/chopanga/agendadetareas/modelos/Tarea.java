package com.chopanga.agendadetareas.modelos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;


@Data
@Table(name = "tarea")
public class Tarea {
    @Id
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_creacion;
    private LocalDateTime fecha_finalizacionestimada;
    private boolean completada;
    private EstadoTarea estado_tarea;


    public Tarea(String nombre, String descripcion, boolean completada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.completada = completada;
    }

    public Tarea() {

    }

}

