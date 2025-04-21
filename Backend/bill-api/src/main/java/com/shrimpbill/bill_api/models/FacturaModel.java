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


    /* Relaciones uno a uno */
    @ManyToOne
    @JoinColumn(name = "fk_usuarios")
    private UsuarioModel usuario;


    /* Getters y setters */

    // Getters y setters para la primary key
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

    // Getter y setter para el usuario
    public void setUsuario(UsuarioModel usuario){
        this.usuario = usuario;
    }

    public UsuarioModel getUsuario(){
        return this.usuario;
    }

}
