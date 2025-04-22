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
    private DatosFiscalesFacturaModel datos_fiscales_factura;

    @OneToOne(mappedBy = "complemento_ine")
    private ComplementoIneEntidadesModel complineentidades;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para tipo_proceso
    public String getTipoProceso() {
        return tipo_proceso;
    }
    public void setTipoProceso(String tipo_proceso) {
        this.tipo_proceso = tipo_proceso;
    }

    // Getter y Setter para tipo_comite
    public String getTipoComite() {
        return tipo_comite;
    }
    public void setTipoComite(String tipo_comite) {
        this.tipo_comite = tipo_comite;
    }

    // Getter y Setter para clave_contabilidad
    public String getClaveContabilidad() {
        return clave_contabilidad;
    }
    public void setClaveContabilidad(String clave_contabilidad) {
        this.clave_contabilidad = clave_contabilidad;
    }

    // Getter y Setter para factura
    public DatosFiscalesFacturaModel getDatosFiscales() {
        return this.datos_fiscales_factura;
    }
    public void setDatosFiscales(DatosFiscalesFacturaModel datos_fiscales_factura) {
        this.datos_fiscales_factura = datos_fiscales_factura;
    }

    // Getter y Setter para complineentidades
    public ComplementoIneEntidadesModel getComplineentidades() {
        return complineentidades;
    }
    public void setComplineentidades(ComplementoIneEntidadesModel complineentidades) {
        this.complineentidades = complineentidades;
    }
}
