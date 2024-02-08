package com.chopanga.agendadetareas.mapper;

import com.chopanga.agendadetareas.modelos.EstadoTarea;
import com.chopanga.agendadetareas.modelos.Tarea;
import com.chopanga.agendadetareas.servicios.dto.TareaEntradaDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Component
public class TareaDtoATarea implements IMapper<TareaEntradaDto, Tarea> {
    @Override
    public Tarea map(TareaEntradaDto in) {
        Tarea tarea = new Tarea();
        tarea.setNombre(in.getNombre());
        tarea.setDescripcion(in.getDescripcion());
        tarea.setFecha_finalizacionestimada(in.getFecha_finalizacionestimada());
        tarea.setCompletada(false);
        tarea.setEstado_tarea(EstadoTarea.ATIEMPO);
        tarea.setFecha_creacion(LocalDateTime.now());
        return tarea;

    }
}
