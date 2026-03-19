package com.duoc.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.Cita;
import com.duoc.veterinaria.repository.CitaRepository;

@Service
public class CitaServiceImpl implements ICitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public void agendarCita(Cita cita) {
        citaRepository.save(cita);
    }

    @Override
    public List<Cita> obtenerTodas() {
        return (List<Cita>) citaRepository.findAll();
    }
}