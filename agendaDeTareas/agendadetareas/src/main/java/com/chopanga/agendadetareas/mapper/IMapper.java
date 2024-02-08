package com.chopanga.agendadetareas.mapper;

public interface IMapper <I, O> {
    O map(I in);
}
