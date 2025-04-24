package com.shrimpbill.bill_api.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shrimpbill.bill_api.models.DomicilioModel;

@Repository
public interface DomicilioRepository
        extends JpaRepository<DomicilioModel, Long> {
    // De momento no ocupamos mas metodos
}
