package com.duoc.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duoc.veterinaria.model.FichaMedica;
import com.duoc.veterinaria.service.IFichaService;

@Controller
@RequestMapping("/fichas")
public class FichaController {

    @Autowired
    private IFichaService fichaService;

    @GetMapping("/nueva")
    public String nuevaFicha(Model model) {
        model.addAttribute("ficha", new FichaMedica());
        return "crear-ficha";
    }

    @PostMapping("/guardar")
    public String guardarFicha(@ModelAttribute FichaMedica ficha) {
        fichaService.guardarFicha(ficha);
        return "redirect:/fichas/historial";
    }

    @GetMapping("/historial")
    public String historial(Model model) {
        model.addAttribute("listaFichas", fichaService.obtenerTodas());
        return "historial-fichas";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarFicha(@PathVariable Long id) {
        fichaService.eliminar(id);
        return "redirect:/fichas/historial";
    }

}
