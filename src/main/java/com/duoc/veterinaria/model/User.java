package com.duoc.veterinaria.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users") // Nombre de la tabla en MySQL
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role; // Agregamos esto para manejar ROLE_ADMIN, ROLE_DUENO, etc.

    // Getters y Setters normales
    

    // MÉTODOS DE USERDETAILS (Los que la guía dejó vacíos)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Esto le dice a Spring Security qué rol tiene este usuario
        return List.of(new SimpleGrantedAuthority(this.role));
    }

    @Override
    public boolean isAccountNonExpired() { return true; } // La cuenta nunca expira

    @Override
    public boolean isAccountNonLocked() { return true; } // La cuenta no se bloquea

    @Override
    public boolean isCredentialsNonExpired() { return true; } // La clave no expira

    @Override
    public boolean isEnabled() { return true; } // El usuario está activo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
