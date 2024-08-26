package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;

public class NovedadVigilante {

    private String fecha;
    private String asunto;
    private String descripcion;
    private int idVigilante;

    public NovedadVigilante(String fecha, String asunto, String descripcion, int idVigilante) {
        this.fecha = fecha;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.idVigilante = idVigilante;
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
        return this.idVigilante;
    }

    public void registrarNovedadDB() {
        String query = "INSERT INTO novedadesvigilante (idVigilante, fecha, Asunto, Peticion) VALUES ("
                + idVigilante + ", '" + fecha + "', '" + asunto + "', '" + descripcion + "')";
        System.out.println("Consulta SQL: " + query); // Para depuración
        DbConnection connection = new DbConnection();

        try {
            connection.updateDataBase(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


