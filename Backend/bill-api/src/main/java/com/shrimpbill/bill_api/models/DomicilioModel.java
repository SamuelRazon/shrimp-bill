package com.shrimpbill.bill_api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "domicilio")
public class DomicilioModel {
     // Declaraciones
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(unique = true, nullable = false)
     private long id;
 
     @Column(nullable = false)
     private String codigo_postal;
 
     @Column(nullable = false)
     private String ciudad;
 
     @Column(nullable = false)
     private String estado;

     @Column(nullable = false)
     private String calle;

     @Column(nullable = false)
     private String numero_exterior;

     @Column(nullable = false)
     private String numero_interior;

     @Column(nullable = false)
     private String colonia;
 
     /* Relacion uno a uno */
     @OneToOne
     @JoinColumn(name = "fk_domicilio")
     private UsuarioModel usuario;


     /* Getters y Setters */
     
     // Getters y setters para la primary key
     public long getId() {
          return id;
     }
     public void setId(long id) {
          this.id = id;
     }
     
     // Getter y Setter para codigo_postal
     public String getCodigoPostal() {
          return codigo_postal;
     }
     public void setCodigoPostal(String codigo_postal) {
          this.codigo_postal = codigo_postal;
     }
     
     // Getter y Setter para ciudad
     public String getCiudad() {
          return ciudad;
     }
     public void setCiudad(String ciudad) {
          this.ciudad = ciudad;
     }
     
     // Getter y Setter para estado
     public String getEstado() {
          return estado;
     }
     public void setEstado(String estado) {
          this.estado = estado;
     }
     
     // Getter y Setter para calle
     public String getCalle() {
          return calle;
     }
     public void setCalle(String calle) {
          this.calle = calle;
     }
     
     // Getter y Setter para numero_exterior
     public String getNumeroExterior() {
          return numero_exterior;
     }
     public void setNumeroExterior(String numero_exterior) {
          this.numero_exterior = numero_exterior;
     }
     
     // Getter y Setter para numero_interior
     public String getNumeroInterior() {
          return numero_interior;
     }
     public void setNumeroInterior(String numero_interior) {
          this.numero_interior = numero_interior;
     }
     
     // Getter y Setter para colonia
     public String getColonia() {
          return colonia;
     }
     public void setColonia(String colonia) {
          this.colonia = colonia;
     }
     
     // Getter y Setter para usuario
     public UsuarioModel getUsuario() {
          return usuario;
     }
     public void setUsuario(UsuarioModel usuario) {
          this.usuario = usuario;
     }
     
}
