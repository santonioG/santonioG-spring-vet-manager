package com.duoc.veterinaria.service;

import java.util.List;

import com.duoc.veterinaria.model.FichaMedica;

public interface IFichaService {
    void guardarFicha(FichaMedica ficha);
    List<FichaMedica> obtenerTodas();
    void eliminar(Long id);  
}
