package com.shrimpbill.bill_api.models;

import java.time.LocalDateTime;
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
@Table(name = "cfdi")
public class CfdiModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String pdf_path;

    @Column(nullable = false)
    private String xml_path;

    @Column(nullable = false)
    private LocalDateTime fecha;

    /* Relaciones uno a uno */
    @OneToOne
    @JoinColumn(name = "fk_factura")
    private FacturaModel factura;

    /* Relaciones muchos a uno */
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private UsuarioModel usuario;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para pdf_path
    public String getPdfPath() {
        return pdf_path;
    }
    public void setPdfPath(String pdf_path) {
        this.pdf_path = pdf_path;
    }

    // Getter y Setter para xml_path
    public String getXmlPath() {
        return xml_path;
    }
    public void setXmlPath(String xml_path) {
        this.xml_path = xml_path;
    }

    // Getter y Setter para fecha
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    // Getter y Setter para factura
    public FacturaModel getFactura() {
        return factura;
    }
    public void setFactura(FacturaModel factura) {
        this.factura = factura;
    }

    // Getter y Setter para usuario
    public UsuarioModel getUsuario() {
        return usuario;
    }
    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}
