package com.chopanga.agendadetareas.servicios.dto;

import com.chopanga.agendadetareas.modelos.EstadoTarea;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TareaEntradaDto {
    private String nombre;
    private String descripcion;
    private LocalDateTime fecha_finalizacionestimada;

}
