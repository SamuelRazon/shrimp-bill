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
@Table(name = "boleto_viaje")
public class BoletoViajeModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String path_abordo;

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

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

    // Getter y Setter para path abordo
    public String getPathAbordo() {
        return this.path_abordo;
    }
    public void setPathAbordo(String path_abordo) {
        this.path_abordo = path_abordo;
    }

    // Getter y Setter para origen
    public String getOrigen() {
        return this.origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }

    // Getter y Setter para destino
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    // Getter y Setter para compra
    public CompraModel getCompra() {
        return compra;
    }
    public void setCompra(CompraModel compra) {
        this.compra = compra;
    }
}
