package com.duoc.veterinaria.service;

import java.util.List;

import com.duoc.veterinaria.model.Cita;

public interface ICitaService {
    void agendarCita(Cita cita);
    List<Cita> obtenerTodas();
}
