package com.shrimpbill.bill_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrimpbill.bill_api.models.DatosFiscalesFacturaModel;

@Repository
public interface DatosFiscalesFacturaRepository
        extends JpaRepository<DatosFiscalesFacturaModel, Long> {
    // De momento no ocupamos mas metodos
}
