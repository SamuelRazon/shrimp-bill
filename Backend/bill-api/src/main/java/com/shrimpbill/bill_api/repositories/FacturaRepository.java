package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shrimpbill.bill_api.models.FacturaModel;

import java.util.Optional;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaModel, Long> {
    // Cambia findByID por findById (minúscula)
    Optional<FacturaModel> findById(long id);
}

