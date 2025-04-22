package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "envios_primera_plus")
public class EnviosPrimeraPlus {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    /* Relacion uno a uno */
    @OneToOne
    @JoinColumn(name = "fk_compra")
    private CompraModel compra;
}
