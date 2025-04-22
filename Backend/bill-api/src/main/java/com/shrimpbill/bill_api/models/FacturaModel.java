package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class FacturaModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String token;

    /* Relacion uno a uno */
    @OneToOne(mappedBy = "factura")
    private CfdiModel cfdi;

    /* Relaciones muchos a uno */
    @ManyToOne
    @JoinColumn(name = "fk_usuarios")
    private UsuarioModel usuario;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para token
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    // Getter y Setter para cfdi
    public CfdiModel getCfdi() {
        return cfdi;
    }
    public void setCfdi(CfdiModel cfdi) {
        this.cfdi = cfdi;
    }

    // Getter y Setter para usuario
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
