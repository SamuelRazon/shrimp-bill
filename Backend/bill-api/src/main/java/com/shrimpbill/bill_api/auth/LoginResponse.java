package com.shrimpbill.bill_api.auth;

public class LoginResponse {
    /**
 * Representa la respuesta de autenticación, que incluye el JWT y los datos del usuario.
 */
    private String token;
    private long id;
    private String nombre;
    private String apellidos;
    private String email;

    public LoginResponse(String token, long id, String nombre, String apellidos, String email) {
        this.token = token;
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
    }
    
    /* Getters */

    // Getter para id
    public long getId() {
        return id;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }
    // Getter para apellidos
    public String getApellidos() {
        return apellidos;
    }

    // Getter para token
    public String getToken() {
        return token;
    }

    // Getter para email
    public String getEmail() {
        return email;
    }
}
