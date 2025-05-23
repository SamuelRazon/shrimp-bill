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
@Table(name = "datos_fiscales_usuario")
public class DatosFiscalesUsuarioModel {
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
    private String uso_cfdi;

    /* Relacion uno a uno */
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioModel usuario;

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

    // Getter y Setter para uso_cfdi
    public String getCfdi() {
        return uso_cfdi;
    }
    public void setCfdi(String uso_cfdi) {
        this.uso_cfdi = uso_cfdi;
    }

    // Getter y Setter para usuario
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
