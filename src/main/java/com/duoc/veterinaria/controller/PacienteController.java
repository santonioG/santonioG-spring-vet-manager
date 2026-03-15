package com.duoc.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.duoc.veterinaria.model.Paciente;
import com.duoc.veterinaria.service.IPacienteService;

@Controller
public class PacienteController {

    @Autowired
    private IPacienteService pacienteService;

    // Ruta para el login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Ruta raíz que redirige al login
    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/pacientes/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("paciente", new Paciente());
        return "registro-paciente";
    }

    @PostMapping("/pacientes/guardar")
    public String guardarPaciente(@ModelAttribute Paciente paciente) {
        pacienteService.guardarPaciente(paciente);
        return "redirect:/pacientes/lista";
    }

    @GetMapping("/pacientes/lista")
    public String listarPacientes(Model model) {
        model.addAttribute("lista", pacienteService.obtenerTodos());
        return "lista-pacientes";
    }
}