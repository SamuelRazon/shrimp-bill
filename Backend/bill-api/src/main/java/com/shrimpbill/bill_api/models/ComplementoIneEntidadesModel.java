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
@Table(name = "complemento_ine_entidades")
public class ComplementoIneEntidadesModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String entidad;

    @Column(nullable = false)
    private String ambito;

    @Column(nullable = false)
    private String clave_contabilidad;

    /* Relaciones uno a uno */
    @OneToOne
    @JoinColumn(name = "fk_complemento_ine")
    private ComplementoIneModel complementoine;
}
