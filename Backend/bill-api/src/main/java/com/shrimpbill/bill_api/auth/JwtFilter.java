package com.shrimpbill.bill_api.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtil jwtUtil;
    /**
     * Aplica el filtrado de JWT a cada petición. Excluye las rutas públicas de login, registro y facturas sin usuario.
     * Si encuentra un token válido, construye una autenticación de Spring sin roles y la añade al SecurityContext.
     *
     * @param req   {@link HttpServletRequest} de la petición entrante.
     * @param res   {@link HttpServletResponse} de la respuesta.
     * @param chain {@link FilterChain} para continuar con el procesamiento.
     * @throws ServletException en errores de servlets.
     * @throws IOException      en errores de I/O.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest req,
                                    HttpServletResponse res,
                                    FilterChain chain)
            throws ServletException, IOException {
    
        String path = req.getServletPath();
    
        // Evita aplicar el filtro en rutas públicas
        if (path.equals("/api/auth/login") || 
            path.equals("/api/auth/registro") || 
            path.equals("/api/facturas/sinusuario")) {
            chain.doFilter(req, res);
            return;
        }
        
    
        String authHeader = req.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                String email = jwtUtil.extractUsername(token);
                // Autenticación básica sin roles aún
                UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(email, null, null);
                auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
    
        chain.doFilter(req, res);
    }    
}
