package com.chopanga.agendadetareas.repositorios;


import com.chopanga.agendadetareas.modelos.EstadoTarea;
import com.chopanga.agendadetareas.modelos.Tarea;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TareaRepositorio extends CrudRepository<Tarea, Long> {


    @Query("SELECT * FROM tarea WHERE estado_tarea = :estado")
    List<Tarea> findAllByEstadoTarea(EstadoTarea estado);

    @Query("UPDATE tarea SET completada = true WHERE id = :id")
    @Modifying
    public void marcarTareaCompletada(Long id);
}
