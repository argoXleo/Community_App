package com.example.frontendcommunityapp.Model.Users;

abstract public class User {

    private int id_usuario;

    private String nombre, telefono, email, password, username;

    public User(int id_usuario, String nombre, String telefono,
                String email, String password, String username) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.password = password;
        this.username = username;

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }


}
