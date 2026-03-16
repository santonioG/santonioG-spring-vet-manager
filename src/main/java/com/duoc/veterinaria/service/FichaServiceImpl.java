package com.duoc.veterinaria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.FichaMedica;

@Service
public class FichaServiceImpl implements IFichaService{

    private final List<FichaMedica> listaFichas = new ArrayList<>();

    @Override
    public void guardarFicha(FichaMedica ficha) {
        listaFichas.add(ficha);
    }

    @Override
    public List<FichaMedica> obtenerTodas() {
        return listaFichas;
    }

}
