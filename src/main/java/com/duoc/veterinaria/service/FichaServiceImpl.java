package com.duoc.veterinaria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duoc.veterinaria.model.FichaMedica;
import com.duoc.veterinaria.repository.FichaRepository;

@Service
public class FichaServiceImpl implements IFichaService {

    @Autowired
    private FichaRepository fichaRepository;

    @Override
    public void guardarFicha(FichaMedica ficha) {
        fichaRepository.save(ficha);
    }

    @Override
    public List<FichaMedica> obtenerTodas() {
        return (List<FichaMedica>) fichaRepository.findAll();
    }
}