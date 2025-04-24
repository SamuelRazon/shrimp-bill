package com.shrimpbill.bill_api.auth;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    // Inyectamos desde application.properties
    @Value("${jwt.secret}")
    private String secretKeyBase64;

    @Value("${jwt.expiration}")
    private long expirationMillis;
        /**
     * Genera la clave de firma a partir de la cadena Base64 configurada.
     *
     * @return {@link Key} para firmar/verificar JWT.
     */
    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKeyBase64);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Crea un JWT con el subject = username, fecha de emisión ahora y fecha de expiración.
     *
     * @param username el identificador de usuario (email).
     * @return token JWT firmado.
     */
    public String generateToken(String username) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + expirationMillis);
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(now)
            .setExpiration(exp)
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)
            .compact();
    }

        /**
     * Extrae el subject (username) de un JWT válido.
     *
     * @param token el JWT a parsear.
     * @return username contenido en el token.
     */
    public String extractUsername(String token) {
        return Jwts.parserBuilder()
            .setSigningKey(getSigningKey())
            .build()
            .parseClaimsJws(token)
            .getBody()
            .getSubject();
    }

    /**
     * Valida la integridad y expiración de un JWT.
     *
     * @param token el token JWT.
     * @return true si es válido, false en caso contrario.
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
