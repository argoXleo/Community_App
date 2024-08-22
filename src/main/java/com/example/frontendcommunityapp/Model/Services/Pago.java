package com.example.frontendcommunityapp.Model.Services;

import com.example.frontendcommunityapp.Controller.DbConnection;
import com.example.frontendcommunityapp.Model.Users.Resident;

import java.sql.ResultSet;

public class Pago extends Services {

    private String cantidad;
    private String concepto;
    private String resident;



    public Pago(int id, String name, String cantidad, String concepto, String resident) {

        super(id, name);
        this.cantidad = cantidad;
        this.concepto = concepto;
        this.resident = resident;

    }

    public String getCantidad() {
        return this.cantidad;
    }

    public String getConcepto() {
        return this.concepto;
    }

    public String getResident() {
        return this.resident;
    }

    public void registrarPagoDB(String cantidad, String concepto, String username ){

        String query = "INSERT INTO pago(cantidad, concepto, username) VALUES( '"+cantidad+"', '"+concepto+"','"+username+"')";
        DbConnection connection = new DbConnection();

        try {
            int rs = connection.updateDataBase(query);


        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        Pago pago1 = new Pago(12,"Pago", "12312", "hola","Jax");
        pago1.registrarPagoDB(pago1.cantidad, pago1.concepto, pago1.resident );
        System.out.println("Yes");
    }

}
