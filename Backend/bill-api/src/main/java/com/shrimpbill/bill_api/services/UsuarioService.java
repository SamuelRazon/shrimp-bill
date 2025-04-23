package com.shrimpbill.bill_api.services;

import com.shrimpbill.bill_api.dto.UsuarioDto;
import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioModel registrar(UsuarioModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<UsuarioModel> login(String email, String password) {
        Optional<UsuarioModel> user = usuarioRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

    // Función para convertir un UsuarioModel a UsuarioDto
    public UsuarioDto toDto(UsuarioModel usuario) {
        return new UsuarioDto(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getApellidos(),
            usuario.getEmail()
        );
    }
}
