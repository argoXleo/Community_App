package com.example.frontendcommunityapp.Model.Services;

import java.util.List;

public class AreasComunes {
    private String nombre;
    private String descripcion;
    private List<String> horariosDisponibles;
    private boolean reservada;
    private int id;

    // Constructor
    public AreasComunes(String nombre, String descripcion, List<String> horariosDisponibles, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.horariosDisponibles = horariosDisponibles;
        this.reservada = false;
        this.id = id;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<String> getHorariosDisponibles() {
        return horariosDisponibles;
    }

    public void setHorariosDisponibles(List<String> horariosDisponibles) {
        this.horariosDisponibles = horariosDisponibles;
    }

    public boolean isReservada() {
        return reservada;
    }

    public void reservar() {
        this.reservada = true;
    }

    public void liberar() {
        this.reservada = false;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Área Común: " + nombre + "\nDescripción: " + descripcion + "\nHorarios Disponibles: " + horariosDisponibles + "\nReservada: " + (reservada ? "Sí" : "No") + "\nID: " + id;
    }
}


