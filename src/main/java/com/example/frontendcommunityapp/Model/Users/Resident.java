package com.example.frontendcommunityapp.Model.Users;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class Resident extends User {

    private String torre;
    private String apto;

    public Resident(int id_usuario, String nombre, String telefono,
                    String email, String password, String username, String torre, String apto) {
        super(id_usuario, nombre, telefono, email, password, username);
        this.torre = torre;
        this.apto = apto;

    }

    public void registrarResidentDB(String nombre, String telefono,
                                 String email, String password, String username ,
                                 String torre, String apto) {

        String query = "INSERT INTO usuarios(nombre, telefono, email, password, " +
                "username, numero_torre, numero_apartamento, Resident) VALUES( '" + nombre + "'," +
                " '" + telefono + "', '" + email + "','" + password + "'," +
                " '" + username + "', '" + torre + "', '" + apto + "', true )";
        DbConnection connection = new DbConnection();

        try {
            int rs = connection.updateDataBase(query);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
