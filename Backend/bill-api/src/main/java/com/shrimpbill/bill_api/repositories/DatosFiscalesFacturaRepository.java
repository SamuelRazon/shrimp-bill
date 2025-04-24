package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrimpbill.bill_api.models.DatosFiscalesFacturaModel;

/**
 * Repositorio JPA para operaciones CRUD sobre {@link DatosFiscalesFacturaModel}.
 * Extiende {@link JpaRepository} para heredar métodos estándar como save, findAll,
 * findById, delete, etc. Actualmente no define métodos personalizados adicionales.
 */
@Repository
public interface DatosFiscalesFacturaRepository
        extends JpaRepository<DatosFiscalesFacturaModel, Long> {
    // De momento no ocupamos mas metodos
}
