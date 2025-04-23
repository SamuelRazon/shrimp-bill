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
    private ComplementoIneModel complemento_ine;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para entidad
    public String getEntidad() {
        return entidad;
    }
    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    // Getter y Setter para ambito
    public String getAmbito() {
        return ambito;
    }
    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    // Getter y Setter para clave_contabilidad
    public String getClaveContabilidad() {
        return clave_contabilidad;
    }
    public void setClaveContabilidad(String clave_contabilidad) {
        this.clave_contabilidad = clave_contabilidad;
    }

    // Getter y Setter para complementoine
    public ComplementoIneModel getComplementoine() {
        return this.complemento_ine;
    }
    public void setComplementoine(ComplementoIneModel complementoine) {
        this.complemento_ine = complementoine;
    }
}
