package com.duoc.veterinaria.repository;
import org.springframework.data.repository.CrudRepository;

import com.duoc.veterinaria.model.Cita;

public interface CitaRepository extends CrudRepository<Cita, Long> {
}