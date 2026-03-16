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
            // 1. Recursos totalmente públicos
            .requestMatchers("/login", "/css/**", "/js/**").permitAll()
            
            // 2. Reglas de Roles (Spring añade ROLE_ automáticamente)
            .requestMatchers("/pacientes/**", "/fichas/**").hasAnyRole("ADMIN", "VETERINARIO")
            .requestMatchers("/citas/**").hasAnyRole("ADMIN", "VETERINARIO", "DUENO")
            
            // 3. El resto requiere estar logueado
            .anyRequest().authenticated()
        )
        .formLogin((form) -> form
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/home", true) // Forzamos redirección a nuestra lógica
            .failureUrl("/login?error=true")
            .permitAll()
        )
        .logout((logout) -> logout
            .logoutSuccessUrl("/login?logout")
            .permitAll()
        );
        
    return http.build();
}

@Bean
public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
    UserDetails admin = User.builder()
            .username("admin")
            .password(passwordEncoder.encode("admin123"))
            .roles("ADMIN")
            .build();

    UserDetails vet = User.builder()
            .username("vet")
            .password(passwordEncoder.encode("vet123"))
            .roles("VETERINARIO")
            .build();

    UserDetails dueno = User.builder()
            .username("dueno")
            .password(passwordEncoder.encode("dueno123"))
            .roles("DUENO") 
            .build();

    return new InMemoryUserDetailsManager(admin, vet, dueno);
}
        @Bean
        public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

