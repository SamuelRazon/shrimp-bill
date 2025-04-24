package com.shrimpbill.bill_api.dto;

/**
 * Informacion que se presentara del usuario en el json de la peticion
 */
public class UsuarioDto {
    private long id;
    private String nombre;
    private String apellidos;
    private String email;

    // Constructor completo
    public UsuarioDto(long id, String nombre, String apellidos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }

    // Getters
    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
