package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shrimpbill.bill_api.models.FacturaModel;

import java.util.Optional;

/**
 * Repositorio JPA para operaciones CRUD sobre {@link FacturaModel}.
 * Extiende {@link JpaRepository} e incluye un método para buscar facturas por su ID.
 */
@Repository
public interface FacturaRepository extends JpaRepository<FacturaModel, Long> {
    // Cambia findByID por findById (minúscula)
    Optional<FacturaModel> findById(long id);
}

