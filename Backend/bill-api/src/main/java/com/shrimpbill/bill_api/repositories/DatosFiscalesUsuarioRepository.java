package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrimpbill.bill_api.models.DatosFiscalesUsuarioModel;


/**
 * Repositorio JPA para operaciones CRUD sobre {@link DatosFiscalesUsuarioModel}.
 * Extiende {@link JpaRepository} para proporcionar métodos estándar de persistencia.
 * No define métodos adicionales por el momento.
 */
@Repository
public interface DatosFiscalesUsuarioRepository
        extends JpaRepository<DatosFiscalesUsuarioModel, Long> {
    // De momento no ocupamos mas metodos
}