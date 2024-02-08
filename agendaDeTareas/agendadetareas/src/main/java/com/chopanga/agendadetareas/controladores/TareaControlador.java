package com.chopanga.agendadetareas.controladores;

import com.chopanga.agendadetareas.modelos.EstadoTarea;
import com.chopanga.agendadetareas.modelos.Tarea;
import com.chopanga.agendadetareas.servicios.TareaServicio;
import com.chopanga.agendadetareas.servicios.dto.TareaEntradaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareaControlador {

    private final TareaServicio tareaServicio;

    public TareaControlador(TareaServicio tareaServicio){
        this.tareaServicio = tareaServicio;
    }

    @GetMapping
    public Iterable<Tarea> getTareas(){
        return tareaServicio.getTareas();
    }

    @PostMapping
    public void crearTarea(@RequestBody TareaEntradaDto tarea){
        tareaServicio.crearTarea(tarea);
    }


    @GetMapping("/estado/{estado}")
    public List<Tarea> findAllByEstadoTarea(@PathVariable("estado") EstadoTarea estado){
        return tareaServicio.findAllByEstadoTarea(estado);
    }

    @PatchMapping("/completar/{id}")
    public ResponseEntity<Void> marcarTareaCompletada(@PathVariable("id") Long id){
        tareaServicio.marcarTareaCompletada(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable("id") Long id){
        tareaServicio.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }




}
