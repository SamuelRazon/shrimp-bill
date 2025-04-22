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
@Table(name = "datos_fiscales_factura")
public class DatosFiscalesFacturaModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String rfc;

    @Column(nullable = false)
    private String razon_social;

    @Column(nullable = false)
    private String regimen_fiscal;

    @Column(nullable = false)
    private String cfdi;

    @Column(nullable = false)
    private String codigo_postal;

    @Column(nullable = false)
    private String ciudad;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String calle;

    @Column(nullable = false)
    private String numero_exterior;

    @Column(nullable = false)
    private String numero_interior;

    @Column(nullable = false)
    private String colonia;

    @Column(nullable = false)
    private String venta_en_linea;

    /* Relaciones uno a uno */
    @OneToOne
    @JoinColumn(name = "fk_factura")
    private FacturaModel factura;

    @OneToOne(mappedBy = "datos_fiscales_factura")
    private ComplementoIneModel complementoine;

    /* Getters y setters */

    // Getters y setters para la primary key
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para rfc
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    // Getter y Setter para razon_social
    public String getRazonSocial() {
        return razon_social;
    }
    public void setRazonSocial(String razon_social) {
        this.razon_social = razon_social;
    }

    // Getter y Setter para regimen_fiscal
    public String getRegimenFiscal() {
        return regimen_fiscal;
    }
    public void setRegimenFiscal(String regimen_fiscal) {
        this.regimen_fiscal = regimen_fiscal;
    }

    // Getter y Setter para cfdi
    public String getCfdi() {
        return cfdi;
    }
    public void setCfdi(String cfdi) {
        this.cfdi = cfdi;
    }

    // Getter y Setter para codigo_postal
    public String getCodigoPostal() {
        return codigo_postal;
    }
    public void setCodigoPostal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    // Getter y Setter para ciudad
    public String getCiudad() {
        return ciudad;
    }
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    // Getter y Setter para estado
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Getter y Setter para calle
    public String getCalle() {
        return calle;
    }
    public void setCalle(String calle) {
        this.calle = calle;
    }

    // Getter y Setter para numero_exterior
    public String getNumeroExterior() {
        return numero_exterior;
    }
    public void setNumeroExterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    // Getter y Setter para numero_interior
    public String getNumeroInterior() {
        return numero_interior;
    }
    public void setNumeroInterior(String numero_interior) {
        this.numero_interior = numero_interior;
    }

    // Getter y Setter para colonia
    public String getColonia() {
        return colonia;
    }
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    // Getter y Setter para venta_en_linea
    public String getVentaEnLinea() {
        return venta_en_linea;
    }
    public void setVentaEnLinea(String venta_en_linea) {
        this.venta_en_linea = venta_en_linea;
    }

    // Getter y Setter para factura
    public FacturaModel getFactura() {
        return factura;
    }
    public void setFactura(FacturaModel factura) {
        this.factura = factura;
    }

    // Getter y Setter para complementoine
    public ComplementoIneModel getComplementoine() {
        return complementoine;
    }
    public void setComplementoine(ComplementoIneModel complementoine) {
        this.complementoine = complementoine;
    }
}
