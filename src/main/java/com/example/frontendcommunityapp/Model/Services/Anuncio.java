package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class Anuncio {


    private String fecha;
    private String asunto;
    private String descripcion;
    private int idAdmin;

    public Anuncio(String fecha, String asunto, String descripcion, int idAdmin) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idAdmin = idAdmin;
    }

    public String getFecha() {
        return this.fecha;
    }

    public String getAsunto() {
        return this.asunto;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public int getIdUsuario() {
        return this.idAdmin;
    }

    public void registrarAnuncioDB() {
        String query = "INSERT INTO anuncio (idAdmin, fecha, asunto, anuncio) VALUES ("
                + idAdmin + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
