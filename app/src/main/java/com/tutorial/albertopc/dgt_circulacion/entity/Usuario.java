package com.tutorial.albertopc.dgt_circulacion.entity;

/**
 * Created by Alberto PC on 30/04/2017.
 */

public class Usuario {
    String usuario;
    String password;
    String nombre;

    public Usuario(String usuario, String password, String nombre) {
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
