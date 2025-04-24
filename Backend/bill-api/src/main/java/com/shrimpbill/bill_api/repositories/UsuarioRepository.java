package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shrimpbill.bill_api.models.UsuarioModel;

import java.util.Optional;


/**
 * Repositorio JPA para operaciones CRUD sobre {@link UsuarioModel}.
 * Extiende {@link JpaRepository} e incluye un método para buscar usuarios por email.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {
    Optional<UsuarioModel> findByEmail(String email);
}
