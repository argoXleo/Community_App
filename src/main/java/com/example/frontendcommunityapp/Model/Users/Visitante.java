package com.example.frontendcommunityapp.Model.Users;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class Visitante {

    private int idVisitante;

    private String nombre;

    private String fecha;

    private String horaVisita;

    private String telefono;

    private String torre;

    private String apto;

    private String docIdentidad;

    private String proposito;


    public Visitante(int idVisitante, String nombre, String fecha,
                     String horaVisita, String telefono, String docIdentidad,
                     String torre, String apto,
                     String proposito) {
        this.idVisitante = idVisitante;
        this.nombre = nombre;
        this.fecha = fecha;
        this.horaVisita = horaVisita;
        this.telefono = telefono;
        this.torre = torre;
        this.apto = apto;
        this.docIdentidad = docIdentidad;
        this.proposito = proposito;
    }


    public int getIdVisitante() {
        return idVisitante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }


    public String getTorre() {
        return torre;
    }

    public String getApto() {
        return apto;
    }

    public String getDocIdentidad() {
        return docIdentidad;
    }

    public void registrarVisitanteDB(String nombre, String fecha, String horaVisita,
                                     String telefono, String docIdentidad, String torre,
                                     String apto, String proposito) {

        String query = "INSERT INTO visitante(nombre, fecha, horaVisita, telefono, docIdentidad," +
                " torre, apto, proposito) VALUES( '" + nombre + "', " +
                " '" + fecha + "', '" + horaVisita + "','" + telefono + "'," +
                " '" + docIdentidad + "', '" + torre + "', '" + apto + "', '" + proposito + "' )";
        DbConnection connection = new DbConnection();

        try {
            int rs = connection.updateDataBase(query);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
