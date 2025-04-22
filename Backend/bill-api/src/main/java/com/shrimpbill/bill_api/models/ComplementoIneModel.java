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
@Table(name = "complemento_ine")
public class ComplementoIneModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String tipo_proceso;

    @Column(nullable = false)
    private String tipo_comite;

    @Column(nullable = false)
    private String clave_contabilidad;

    /* Relaciones uno a uno */
    @OneToOne
    @JoinColumn(name = "fk_datos_fiscales")
    private FacturaModel factura;

    @OneToOne(mappedBy = "complemento_ine")
    private ComplementoIneEntidadesModel complineentidades;
}
