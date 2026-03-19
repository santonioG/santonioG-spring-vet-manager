package com.duoc.veterinaria.repository;
import org.springframework.data.repository.CrudRepository;

import com.duoc.veterinaria.model.FichaMedica;

public interface FichaRepository extends CrudRepository<FichaMedica, Long> {
}