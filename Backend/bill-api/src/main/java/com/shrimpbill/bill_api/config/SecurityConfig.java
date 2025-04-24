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

/**
 * Configuración de seguridad de Spring Security para la API.
 * Deshabilita CSRF (útil para APIs REST), configura las rutas públicas
 * y protege el resto de endpoints con JWT, además de definir la política
 * de sesión como stateless (sin estado).
 */
@Configuration
public class SecurityConfig {

    @Autowired 
    private JwtFilter jwtFilter;
    /**
     * Construye la cadena de filtros de seguridad.
     * 
     * @param http objeto HttpSecurity para configurar CSRF, autorizaciones y sesiones.
     * @return SecurityFilterChain construido.
     * @throws Exception en caso de errores al aplicar la configuración.
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilita CSRF, esto ayuda a las Apis Rest con llamadas que no ocupan autorizacion
            .csrf(csrf -> csrf.disable())

            // 2. Define reglas de autorización
            .authorizeHttpRequests(auth -> auth
                // 2.1 Rutas públicas
                .requestMatchers(
                    "/api/auth/registro",  // Endpoint para crear usuario + token
                    "/api/auth/login",      // Endpoint para login + token
                    "/api/facturas/sinusuario" // Endpoint para facturar sin estar registrado como usuario
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
