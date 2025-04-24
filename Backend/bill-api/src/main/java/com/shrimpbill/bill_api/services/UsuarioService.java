package com.shrimpbill.bill_api.services;

import com.shrimpbill.bill_api.dto.UsuarioDto;
import com.shrimpbill.bill_api.models.UsuarioModel;
import com.shrimpbill.bill_api.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para operaciones relacionadas con usuarios:
 * registro, autenticación y conversión a DTO.
 */
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Registra un nuevo usuario, encriptando su contraseña.
     *
     * @param usuario modelo de usuario con datos sin procesar.
     * @return el {@link UsuarioModel} persistido con contraseña encriptada.
     */
    public UsuarioModel registrar(UsuarioModel usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    /**
     * Intenta autenticar a un usuario comparando la contraseña en claro
     * con la almacenada en la base de datos (ya hasheada).
     *
     * @param email    correo electrónico del usuario.
     * @param password contraseña en texto plano introducida.
     * @return Optional con el usuario si coincide, o vacío en caso contrario.
     */
    public Optional<UsuarioModel> login(String email, String password) {
        Optional<UsuarioModel> user = usuarioRepository.findByEmail(email);
        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return user;
        }
        return Optional.empty();
    }

        /**
     * Busca un usuario por su correo electrónico.
     *
     * @param email correo del usuario.
     * @return Optional con el usuario si existe, o vacío.
     */
    /* Encontrar usuario a traves del email */
    public Optional<UsuarioModel> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

        /**
     * Convierte un {@link UsuarioModel} a su representación DTO
     * para no exponer campos sensibles.
     *
     * @param usuario modelo de usuario.
     * @return {@link UsuarioDto} con datos públicos.
     */
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
