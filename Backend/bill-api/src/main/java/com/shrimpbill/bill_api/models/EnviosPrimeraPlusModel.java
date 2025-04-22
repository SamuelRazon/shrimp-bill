package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "envios_primera_plus")
public class EnviosPrimeraPlusModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    /* Relacion muchos a uno */
    @ManyToOne
    @JoinColumn(name = "fk_compra")
    private CompraModel compra;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para compra
    public CompraModel getCompra() {
        return compra;
    }
    public void setCompra(CompraModel compra) {
        this.compra = compra;
    }
}
