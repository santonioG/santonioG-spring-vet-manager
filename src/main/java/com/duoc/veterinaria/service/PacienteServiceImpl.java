package com.duoc.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.repository.PacienteRepository;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Override
    public void guardarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente); // Guarda en MySQL
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return (List<Paciente>) pacienteRepository.findAll();
    }

    @Override
    public Paciente buscarPorNombre(String nombre) {
        return pacienteRepository.findByNombre(nombre);
    }
}