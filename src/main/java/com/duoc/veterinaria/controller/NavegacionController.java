package com.duoc.veterinaria.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavegacionController {

    // 1. Esta ruta es vital para mostrar HTML de login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // 2. La ruta raíz decide a dónde mandar
    @GetMapping("/")
    public String index(Authentication auth) {
        if (auth != null && auth.isAuthenticated()) {
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    // 3. El home decide según el ROL
    @GetMapping("/home")
    public String home(Authentication auth) {
        if (auth == null) return "redirect:/login";

        boolean esDueno = auth.getAuthorities().stream()
                .anyMatch(r -> r.getAuthority().equals("ROLE_DUENO"));

        if (esDueno) {
            return "redirect:/citas/lista";
        }

        return "redirect:/pacientes/lista";
    }
}