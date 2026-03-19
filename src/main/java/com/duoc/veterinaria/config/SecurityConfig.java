package com.duoc.veterinaria.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // Desactivamos CSRF porque usaremos JWT para la API
            .csrf(csrf -> csrf.disable())
            
            .authorizeHttpRequests((requests) -> requests
                // Rutas Públicas (Login HTML y Login API)
                .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                .requestMatchers(HttpMethod.POST, SecurityConstants.LOGIN_URL).permitAll()
                
                // Reglas de Roles para la Web/API
                .requestMatchers("/pacientes/**", "/fichas/**").hasAnyRole("ADMIN", "VETERINARIO")
                .requestMatchers("/citas/**").hasAnyRole("ADMIN", "VETERINARIO", "DUENO")
                
                // El resto requiere estar logueado
                .anyRequest().authenticated()
            )
            
            // Configuración para el LOGIN WEB (HTML)
            .formLogin((form) -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .permitAll()
            )
            
            //AGREGAMOS EL FILTRO JWT (Para la seguridad de la API)
            .addFilterAfter(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    // EL ÚNICO BEAN DE PASSWORD ENCODER
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
}


}