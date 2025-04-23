package com.shrimpbill.bill_api.auth;

public class LoginRequest {
    private String email;
    private String password;
    
    /* Getters y Setters */
    /* Setter y Getter de password */ 
    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
}