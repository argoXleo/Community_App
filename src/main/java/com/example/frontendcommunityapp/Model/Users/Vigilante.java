package com.example.frontendcommunityapp.Model.Users;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class Vigilante extends User {



    public Vigilante(int id_usuario, String nombre, String telefono,
                     String email, String password, String username) {
        super(id_usuario, nombre, telefono, email, password, username);

    }

    public void registrarVigilanteDB(String nombre, String telefono,
                                    String email, String password, String username) {

        String query = "INSERT INTO usuarios(nombre, telefono, email, password, " +
                "username, Vigilante) VALUES( '" + nombre + "'," +
                " '" + telefono + "', '" + email + "','" + password + "'," +
                " '" + username + "', true )";
        DbConnection connection = new DbConnection();

        try {
            int rs = connection.updateDataBase(query);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
