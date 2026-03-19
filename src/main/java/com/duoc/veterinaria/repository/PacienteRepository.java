package com.duoc.veterinaria.repository;
import org.springframework.data.repository.CrudRepository;

import com.duoc.veterinaria.model.Paciente;

public interface PacienteRepository extends CrudRepository<Paciente, Long> {
    Paciente findByNombre(String nombre); // Spring genera el SQL automáticamente
}