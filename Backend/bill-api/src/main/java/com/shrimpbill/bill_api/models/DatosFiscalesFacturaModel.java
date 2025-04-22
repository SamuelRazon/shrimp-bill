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
    public void setrfc(String rfc) {
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

}
