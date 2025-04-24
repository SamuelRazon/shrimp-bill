package com.shrimpbill.bill_api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrimpbill.bill_api.models.DomicilioModel;

/**
 * Repositorio JPA para operaciones CRUD sobre {@link DomicilioModel}.
 * Extiende {@link JpaRepository} para heredar las operaciones básicas de persistencia.
 * Actualmente no se requieren métodos personalizados.
 */
@Repository
public interface DomicilioRepository
        extends JpaRepository<DomicilioModel, Long> {
    // De momento no ocupamos mas metodos
}
