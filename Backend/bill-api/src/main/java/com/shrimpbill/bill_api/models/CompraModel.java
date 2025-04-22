package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

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
    @OneToOne(mappedBy = "compra")
    private BoletoViajeModel boletoviaje;

    /* Uno a Uno */
    @OneToOne(mappedBy = "compra")
    private CompraAlimentosModel compraalimentos;

    /* Uno a Uno */
    @OneToOne(mappedBy = "compra")
    private EnviosPrimeraPlus enviosprimeraplus;

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
    public BoletoViajeModel getBoletoviaje() {
        return boletoviaje;
    }
    public void setBoletoviaje(BoletoViajeModel boletoviaje) {
        this.boletoviaje = boletoviaje;
    }

    // Getter y Setter para compraalimentos
    public CompraAlimentosModel getCompraalimentos() {
        return compraalimentos;
    }
    public void setCompraalimentos(CompraAlimentosModel compraalimentos) {
        this.compraalimentos = compraalimentos;
    }

    // Getter y Setter para enviosprimeraplus
    public EnviosPrimeraPlus getEnviosprimeraplus() {
        return enviosprimeraplus;
    }
    public void setEnviosprimeraplus(EnviosPrimeraPlus enviosprimeraplus) {
        this.enviosprimeraplus = enviosprimeraplus;
    }
}
