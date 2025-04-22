package com.shrimpbill.bill_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
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

    @Column(nullable = false)
    @Lob
    private String csd_emisor;

    @Column(nullable = false)
    @Lob
    private String qr_datos;

    /* Relacion uno a uno */
    @OneToOne(mappedBy = "factura")
    private CfdiModel cfdi;
    
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

     // Getter y Setter para csd_emisor
     public String getCsd_emisor() {
        return csd_emisor;
    }
    public void setCsd_emisor(String csd_emisor) {
        this.csd_emisor = csd_emisor;
    }

    // Getter y Setter para qr_datos
    public String getQr_datos() {
        return qr_datos;
    }
    public void setQr_datos(String qr_datos) {
        this.qr_datos = qr_datos;
    }

    // Getter y Setter para uso_cfdi
    public CfdiModel getCfdi() {
        return this.cfdi;
    }
    public void setCfdi(CfdiModel cfdi) {
        this.cfdi = cfdi;
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
