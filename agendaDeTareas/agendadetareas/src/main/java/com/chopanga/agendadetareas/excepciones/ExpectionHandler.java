package com.chopanga.agendadetareas.excepciones;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExpectionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {AgendaExcepciones.class})
    protected ResponseEntity<Object> handleConflict(
            AgendaExcepciones ex, WebRequest request){
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), ex.getStatus(), request);

    }

}
