// src/main/java/com/shrimpbill/bill_api/config/SecurityConfig.java
package com.shrimpbill.bill_api.config;

import com.shrimpbill.bill_api.auth.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired 
    private JwtFilter jwtFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilita CSRF, esto ayuda a las Apis Rest con llamadas que no ocupan autorizacion
            .csrf(csrf -> csrf.disable())

            // 2. Define reglas de autorización
            .authorizeHttpRequests(auth -> auth
                // 2.1 Rutas públicas: registro y login de autenticación
                .requestMatchers(
                    "/api/auth/registro",  // Endpoint para crear usuario + token
                    "/api/auth/login"      // Endpoint para login + token
                ).permitAll()

                // 2.3 Todas las demás peticiones requieren un JWT válido
                .anyRequest().authenticated()
            )

            // 3. No usamos sesiones HTTP, cada petición lleva su propio token
            .sessionManagement(sm -> 
                sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        // 4. Añade el filtro JWT antes del filtro de autenticación por usuario
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
