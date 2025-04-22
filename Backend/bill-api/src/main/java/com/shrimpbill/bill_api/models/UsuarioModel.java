package com.shrimpbill.bill_api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModel {
    // Declaraciones de atributos iguales a la tabla de la base de datos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    /* Relaciones entre tablas */
    /* Uno a Uno */
    @OneToOne(mappedBy = "usuario")
    private DomicilioModel domicilio;

    @OneToOne(mappedBy = "usuario")
    private DatosFiscalesUsuarioModel datosfiscales;

    /* Relacion uno a muchos */
    @OneToMany(mappedBy = "usuario")
    private List<FacturaModel> facturas;

    @OneToMany(mappedBy = "usuario")
    private List<CfdiModel> cfdi;

    /* Getters y setters */

    // Getter y Setter para id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    // Getter y Setter para nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para apellidos
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Getter y Setter para email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter y Setter para password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter y Setter para domicilio
    public DomicilioModel getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(DomicilioModel domicilio) {
        this.domicilio = domicilio;
    }

    // Getter y Setter para datosfiscales
    public DatosFiscalesUsuarioModel getDatosfiscales() {
        return datosfiscales;
    }
    public void setDatosfiscales(DatosFiscalesUsuarioModel datosfiscales) {
        this.datosfiscales = datosfiscales;
    }

    // Getter y Setter para facturas
    public List<FacturaModel> getFacturas() {
        return facturas;
    }
    public void setFacturas(List<FacturaModel> facturas) {
        this.facturas = facturas;
    }

    // Getter y Setter para cfdi
    public List<CfdiModel> getCfdi() {
        return cfdi;
    }
    public void setCfdi(List<CfdiModel> cfdi) {
        this.cfdi = cfdi;
    }
}
