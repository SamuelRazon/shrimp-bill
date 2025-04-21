package com.shrimpbill.bill_api.controllers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario")
public class UsuarioModel {
    // Declaraciones
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private long id;

    @Column(nullable = false)
    private String nombre;

    @Column(unique = true,nullable = false)
    private String apellidos;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(unique = true,nullable = false)
    private String password;

    //
    private long fk_domicilio;
    private long fk_datos_fiscales;


    // Getters y setters
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getFk_domicilio() {
        return fk_domicilio;
    }
    public void setFk_domicilio(long fk_domicilio) {
        this.fk_domicilio = fk_domicilio;
    }
    public long getFk_datos_fiscales() {
        return fk_datos_fiscales;
    }
    public void setFk_datos_fiscales(long fk_datos_fiscales) {
        this.fk_datos_fiscales = fk_datos_fiscales;
    }

}
