package com.parqueadero.backend.dto;

public class LoginDTO {
    private String usuario;
    private String contraseña;

    // Constructor vacío
    public LoginDTO() {}

    // Getters y Setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
