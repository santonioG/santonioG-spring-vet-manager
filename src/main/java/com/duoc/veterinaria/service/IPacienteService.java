package com.duoc.veterinaria.service;

import java.util.List;

import com.duoc.veterinaria.model.Paciente;

public interface IPacienteService {

    void guardarPaciente(Paciente paciente);
    List<Paciente> obtenerTodos();
    Paciente buscarPorNombre(String nombre);

}
