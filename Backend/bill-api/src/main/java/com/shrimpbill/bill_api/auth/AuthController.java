package com.shrimpbill.bill_api.auth;

import com.shrimpbill.bill_api.dto.UsuarioDto;
import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.services.UsuarioService;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private UsuarioService usuarioService;
    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/registro")
    public ResponseEntity<LoginResponse> registro(@RequestBody UsuarioModel usuario) {
        UsuarioModel u = usuarioService.registrar(usuario);
        String token = jwtUtil.generateToken(u.getEmail());
        UsuarioDto dto = usuarioService.toDto(u);
        return ResponseEntity.ok(
            new LoginResponse(token, dto.getId(), dto.getNombre(), dto.getApellidos(), dto.getEmail())
        );
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        Optional<UsuarioModel> loginOpt = usuarioService.login(req.getEmail(), req.getPassword());
    
        if (loginOpt.isPresent()) {
            UsuarioModel u = loginOpt.get();
            String token = jwtUtil.generateToken(u.getEmail());
            UsuarioDto dto = usuarioService.toDto(u);
            LoginResponse resp = new LoginResponse(
                token,
                dto.getId(),
                dto.getNombre(),
                dto.getApellidos(),
                dto.getEmail()
            );
            return ResponseEntity.ok(resp);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UsuarioDto> me(Authentication auth) {
        // 'auth.getName()' es el email extraído del token
        UsuarioModel user = usuarioService.findByEmail(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
        return ResponseEntity.ok(usuarioService.toDto(user));
    }
    
}
