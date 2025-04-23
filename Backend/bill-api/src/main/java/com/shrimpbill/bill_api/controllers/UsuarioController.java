package com.shrimpbill.bill_api.controllers;

import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.services.UsuarioService;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*") // Cambia "*" por tu dominio Angular si es necesario
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody UsuarioModel usuario) {
        return ResponseEntity.ok(usuarioService.registrar(usuario));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioModel usuario) {
        Optional<UsuarioModel> loginResult = usuarioService.login(usuario.getEmail(), usuario.getPassword());
    
        if (loginResult.isPresent()) {
            return ResponseEntity.ok(loginResult.get());
        } else {
            return ResponseEntity.status(401).body("Credenciales inválidas");
        }
    }      

}
