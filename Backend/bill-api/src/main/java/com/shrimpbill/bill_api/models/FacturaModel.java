package com.shrimpbill.bill_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private CfdiModel uso_cfdi;
    
    @OneToOne(mappedBy = "factura")
    private DatosFiscalesFacturaModel datosfiscalesfactura;

    /* Relaciones muchos a uno */
    @ManyToOne
    @JoinColumn(name = "fk_usuarios")
    private UsuarioModel usuario;
    
    @OneToMany(mappedBy = "factura")
    private List<CompraModel> compra;

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

    // Getter y Setter para uso_cfdi
    public CfdiModel getCfdi() {
        return uso_cfdi;
    }
    public void setCfdi(CfdiModel uso_cfdi) {
        this.uso_cfdi = uso_cfdi;
    }

    // Getter y Setter para datosdeusuario
    public List<CompraModel> getCompra() {
        return this.compra;
    }
    public void setCompra(List<CompraModel> compra) {
        this.compra = compra;
    }

    // Getter y Setter para datosdeusuario
    public DatosFiscalesFacturaModel getDatosFiscalesFactura() {
        return this.datosfiscalesfactura;
    }
    public void setDatosFiscalesFactura(DatosFiscalesFacturaModel datosfiscales) {
        this.datosfiscalesfactura = datosfiscales;
    }

    // Getter y Setter para usuario
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
