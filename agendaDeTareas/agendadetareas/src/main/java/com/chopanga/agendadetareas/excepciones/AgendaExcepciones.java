package com.chopanga.agendadetareas.excepciones;

import lombok.Data;
import org.springframework.http.HttpStatus;


@Data
public class AgendaExcepciones extends RuntimeException {
    private String mensaje;
    private HttpStatus status;


    public AgendaExcepciones(String mensaje, HttpStatus status) {
        super(mensaje);
        this.mensaje = mensaje;
        this.status = status;
    }

}
