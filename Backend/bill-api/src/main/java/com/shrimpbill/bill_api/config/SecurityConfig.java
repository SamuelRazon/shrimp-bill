package com.shrimpbill.bill_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Para POST desde Postman sin token 
            .csrf(csrf -> csrf.disable())
            // 2. Configura quién necesita autenticarse
            .authorizeHttpRequests(auth -> auth
                // rutas públicas
                .requestMatchers("/api/usuarios/registro", "/api/usuarios/login").permitAll()
                // cualquier otra ruta requiere autenticación
                .anyRequest().authenticated()
            )
            // 3. No mantenemos sesión en el servidor 
            .sessionManagement(sess -> sess
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            // 4. Mantenemos el entry point para HTTP Basic (solo pruebas)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
