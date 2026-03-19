package com.duoc.veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.Cita;

@Service
public class CitaServiceImpl implements ICitaService {
    private final List<Cita> listaCitas = new ArrayList<>();

    @Override
    public void agendarCita(Cita cita) {
        listaCitas.add(cita);
    }

    @Override
    public List<Cita> obtenerTodas() {
        return listaCitas;
    }
    
}
                                                                                                                          