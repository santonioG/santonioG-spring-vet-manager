package com.duoc.veterinaria.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//indica que esta clase contiene configuracion de Spring
@Configuration
// activa la seguridad web de Spring Security
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Define las reglas de seguridad HTTP:
     * qué rutas son publicas, cual es la pag de login, ect.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        // Rutas públicas: cualquier usuario puede acceder sin autenticarse
                        .requestMatchers("/", "/login", "/css/**").permitAll()
                        // Cualquier otra ruta requiere que el usuario esté autenticado
                        .anyRequest().authenticated())
                .formLogin((form) -> form
                        // Pagina de login personalizada
                        .loginPage("/login")
                        .loginProcessingUrl("/login")
                        // Redirige al usuario aquí tras iniciar esión exitosamente
                        .defaultSuccessUrl("/pacientes/lista", true)
                        // permite acceder al login sin estar autenticado
                        .permitAll())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );        
        return http.build();
    }

    /**
     * Define los usuarios de la aplicación almacenados en memoria.
     * En producción esto debería venir de una base de datos,
     * pero para este proyecto usamos InMemoryUserDetailsManager.
     * Recibe el PasswordEncoder como parámetro para que Spring lo inyecte
     * automáticamente (evita llamarlo directamente y mejora el diseño).
     */
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        // Usuario con rol ADMIN: acceso total al sistema
        UserDetails user1 = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin123")) // Contraseña con BCrypt
                .roles("ADMIN")
                .build();
        // Usuario con rol VETERINARIO: acceso a funciones del veterinario
        UserDetails user2 = User.builder()
                .username("vet")
                .password(passwordEncoder.encode("vet123"))
                .roles("VETERINARIO")
                .build();
        // Usuario con rol USER: acceso básico (dueño de mascota)
        UserDetails user3 = User.builder()
                .username("dueno")
                .password(passwordEncoder.encode("dueno123"))
                .roles("USER")
                .build();

        // Retorna el gestor de usuarios en memoria con los 3 usuarios definidos
        return new InMemoryUserDetailsManager(user1, user2, user3);
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

