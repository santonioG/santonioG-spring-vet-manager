package com.duoc.veterinaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.veterinaria.config.JWTAuthenticationConfig;
import com.duoc.veterinaria.service.MyUserDetailsService;

@RestController
public class LoginController {

    @Autowired
    private JWTAuthenticationConfig jwtAuthenticationConfig;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @PostMapping("/api/login")
    public String login(
            @RequestParam("user") String username,
            @RequestParam("encryptedPass") String encryptedPass) {

        // Buscamos al usuario en la base de datos (Docker MySQL)
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // Validación de seguridad REAL:
        // Usamos passwordEncoder.matches para comparar la clave que llega 
        // con la que está guardada (que debería estar hasheada).
        if (!passwordEncoder.matches(encryptedPass, userDetails.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }

        // Generamos el token JWT
        return jwtAuthenticationConfig.getJWTToken(username);
    }
}