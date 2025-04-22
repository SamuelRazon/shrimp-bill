package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compra")
public class CompraModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String token;

    @Column(nullable = false)
    private long precio;

    @Column(nullable = false)
    private String cantidad;

    @Column(nullable = false)
    private LocalDateTime fecha;

    /* Relaciones entre tablas */
    /* Uno a Uno */
    @OneToMany(mappedBy = "compra")
    private List<BoletoViajeModel> boletoviaje;

    /* Uno a Uno */
    @OneToMany(mappedBy = "compra")
    private List<CompraAlimentosModel> compraalimentos;

    /* Uno a Uno */
    @OneToMany(mappedBy = "compra")
    private List<EnviosPrimeraPlusModel> enviosprimeraplus;

    /* Relaciones uno a uno */
    @ManyToOne
    @JoinColumn(name = "fk_factura")
    private FacturaModel factura;

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

    // Getter y Setter para precio
    public long getPrecio() {
        return precio;
    }
    public void setPrecio(long precio) {
        this.precio = precio;
    }

    // Getter y Setter para cantidad
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y Setter para fecha
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para boletoviaje
    public List<BoletoViajeModel> getBoletoviaje() {
        return boletoviaje;
    }
    public void setBoletoviaje(List<BoletoViajeModel> boletoviaje) {
        this.boletoviaje = boletoviaje;
    }

    // Getter y Setter para compraalimentos
    public List<CompraAlimentosModel> getCompraalimentos() {
        return compraalimentos;
    }
    public void setCompraalimentos(List<CompraAlimentosModel> compraalimentos) {
        this.compraalimentos = compraalimentos;
    }

    // Getter y Setter para factura
    public FacturaModel getFactura() {
        return factura;
    }
    public void setFactura(FacturaModel factura) {
        this.factura = factura;
    }

    // Getter y Setter para enviosprimeraplus
    public List<EnviosPrimeraPlusModel> getEnviosprimeraplus() {
        return enviosprimeraplus;
    }
    public void setEnviosprimeraplus(List<EnviosPrimeraPlusModel> enviosprimeraplus) {
        this.enviosprimeraplus = enviosprimeraplus;
    }
}
