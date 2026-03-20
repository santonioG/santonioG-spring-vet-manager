package com.duoc.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.duoc.veterinaria.model.Cita;
import com.duoc.veterinaria.service.ICitaService;


@Controller
@RequestMapping("/citas")
public class CitaController {

    @Autowired
    private ICitaService citaService;

    @GetMapping("/agendar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cita", new Cita());
        return "agendar-cita";
    }

    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute Cita cita){
        citaService.agendarCita(cita);
        return "redirect:/citas/lista";
    }

    @GetMapping("/lista")
    public String listarCitas(Model model) {
        model.addAttribute("listaCitas", citaService.obtenerTodas());
        return "lista-citas";
    }
    
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("cita", citaService.buscarPorId(id));
        return "agendar-cita"; // reutilizamos el mismo formulario
    }

    @PostMapping("/actualizar")
    public String actualizarCita(@ModelAttribute Cita cita) {
        citaService.agendarCita(cita);
        return "redirect:/citas/lista";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarCita(@PathVariable Long id) {
        citaService.eliminar(id);
        return "redirect:/citas/lista";
    }
    

}
