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

    /**
     * Registra un nuevo usuario, genera un JWT y devuelve los datos básicos junto con el token.
     *
     * @param usuario objeto {@link UsuarioModel} con los datos del nuevo usuario.
     * @return {@link ResponseEntity} con un {@link LoginResponse} que incluye el token y datos del usuario.
     */
    @PostMapping("/registro")
    public ResponseEntity<LoginResponse> registro(@RequestBody UsuarioModel usuario) {
        UsuarioModel u = usuarioService.registrar(usuario);
        String token = jwtUtil.generateToken(u.getEmail());
        UsuarioDto dto = usuarioService.toDto(u);
        return ResponseEntity.ok(
            new LoginResponse(token, dto.getId(), dto.getNombre(), dto.getApellidos(), dto.getEmail())
        );
    }

    /**
     * Autentica a un usuario existente mediante correo y contraseña.
     * Si las credenciales son válidas, genera y devuelve un JWT.
     *
     * @param req objeto {@link LoginRequest} con email y password.
     * @return {@link ResponseEntity} con {@link LoginResponse} o estado 401 en caso de credenciales inválidas.
     */
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

    /**
     * Devuelve la información del usuario actualmente autenticado.
     * El email se extrae del JWT validado por el filtro de seguridad.
     *
     * @param auth objeto {@link Authentication} con el nombre de usuario (email).
     * @return {@link ResponseEntity} con {@link UsuarioDto} del usuario autenticado.
     * @throws UsernameNotFoundException si no se encuentra el usuario en la base de datos.
     */
    @GetMapping("/me")
    public ResponseEntity<UsuarioDto> me(Authentication auth) {
        UsuarioModel user = usuarioService.findByEmail(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no existe"));
        return ResponseEntity.ok(usuarioService.toDto(user));
    }
}
