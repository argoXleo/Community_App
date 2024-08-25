package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class Queja {

    private String fecha;
    private String asunto;
    private String descripcion;
    private int idUsuario;

    public Queja(String fecha, String asunto, String descripcion, int idUsuario) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idUsuario = idUsuario;
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
        return this.idUsuario;
    }

    public void registrarQuejaDB() {
        String query = "INSERT INTO peticiones_y_quejas (IDUsuario, Fecha, Asunto, Descripcion) VALUES ("
                + idUsuario + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
