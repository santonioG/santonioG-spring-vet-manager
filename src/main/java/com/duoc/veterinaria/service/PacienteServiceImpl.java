package com.duoc.veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService {

    // La "base de datos" temporal
    private final List<Paciente> listaPacientes = new ArrayList<>();

    @Override
    public void guardarPaciente(Paciente paciente) {
        listaPacientes.add(paciente);
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return listaPacientes;
    }

    @Override
    public Paciente buscarPorNombre(String nombre) {
        return listaPacientes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst()
                .orElse(null);
    }
}
