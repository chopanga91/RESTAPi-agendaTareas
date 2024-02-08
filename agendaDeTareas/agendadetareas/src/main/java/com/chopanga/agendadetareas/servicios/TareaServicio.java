package com.chopanga.agendadetareas.servicios;

import com.chopanga.agendadetareas.excepciones.AgendaExcepciones;
import com.chopanga.agendadetareas.mapper.TareaDtoATarea;
import com.chopanga.agendadetareas.modelos.EstadoTarea;
import com.chopanga.agendadetareas.modelos.Tarea;
import com.chopanga.agendadetareas.repositorios.TareaRepositorio;
import com.chopanga.agendadetareas.servicios.dto.TareaEntradaDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TareaServicio {

    private final TareaRepositorio tareaRepositorio;
    private final TareaDtoATarea mapper;

    public TareaServicio(TareaRepositorio tareaRepositorio, TareaDtoATarea mapper) {
        this.tareaRepositorio = tareaRepositorio;
        this.mapper = mapper;
    }

    public Iterable<Tarea> getTareas(){
        return tareaRepositorio.findAll();
    }

    public void crearTarea(TareaEntradaDto tareaEntradaDto){
        Tarea tarea = mapper.map(tareaEntradaDto);
        tareaRepositorio.save(tarea);
    }

    public List<Tarea> findAllByEstadoTarea(EstadoTarea estado){
        return tareaRepositorio.findAllByEstadoTarea(estado);
    }

    @Transactional
    public void marcarTareaCompletada(Long id){
        Optional<Tarea> tareaOpcional = tareaRepositorio.findById(id);
        if (tareaOpcional.isEmpty()){
            throw new AgendaExcepciones("La tarea no existe", HttpStatus.NOT_FOUND);
        }
        tareaRepositorio.marcarTareaCompletada(id);
    }

    @Transactional
    public void eliminarTarea(Long id){
        Optional<Tarea> tareaOpcional = tareaRepositorio.findById(id);
        if (tareaOpcional.isEmpty()){
            throw new AgendaExcepciones("La tarea no existe", HttpStatus.NOT_FOUND);
        }
        tareaRepositorio.deleteById(id);
    }






}
