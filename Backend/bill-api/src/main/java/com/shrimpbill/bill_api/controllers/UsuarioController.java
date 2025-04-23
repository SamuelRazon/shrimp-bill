package com.shrimpbill.bill_api.controllers;

import com.shrimpbill.bill_api.dto.UsuarioDto;
import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.services.UsuarioService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<UsuarioDto> registrar(@RequestBody UsuarioModel usuario) {
        UsuarioModel usuarioCreado = usuarioService.registrar(usuario);
        UsuarioDto dto = usuarioService.toDto(usuarioCreado);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioModel usuario) {
        Optional<UsuarioModel> loginResult = usuarioService.login(usuario.getEmail(), usuario.getPassword());
    
        if (loginResult.isPresent()) {
            UsuarioDto dto = usuarioService.toDto(loginResult.get());
            return ResponseEntity.ok(dto);
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }    
}
