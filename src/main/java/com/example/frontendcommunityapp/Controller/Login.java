package com.example.frontendcommunityapp.Controller;

import com.example.frontendcommunityapp.Model.Resident;
import com.example.frontendcommunityapp.Model.User;


import java.sql.ResultSet;

public class Login {


    public User userLogin(String userName, String password){
        String query = "SELECT * FROM usuarios WHERE username = '"+userName+"' AND password = '"+ password+"'";
        DbConnection connection = new DbConnection();
        try {

            ResultSet rs = connection.getQueryTable(query);
            if (rs.next()) {
                return new Resident(rs.getInt("id_usuario"),
                                    rs.getString("nombre"),
                                    rs.getString("telefono"),
                                    rs.getString("email"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Login login = new Login();
        Resident resident = (Resident) login.userLogin("Jax", "asdsa");
        System.out.println("Welcome " + resident.getNombre());
        //System.out.println(login.userLogin("Jack", "1234"));
    }
}
