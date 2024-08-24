package com.example.frontendcommunityapp.Controller;

import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.User;
import com.example.frontendcommunityapp.Model.Users.Vigilante;


import java.sql.ResultSet;

public class Login {


    public User userLogin(String userName, String password){
        String query = "SELECT * FROM usuarios WHERE username = '"+userName+"' AND password = '"+ password+"'";
        DbConnection connection = new DbConnection();
        try {

            ResultSet rs = connection.getQueryTable(query);
            rs.next();
            if (rs.getBoolean(10) == true) {
                return new Resident(rs.getInt("id_usuario"),
                                    rs.getString("nombre"),
                                    rs.getString("telefono"),
                                    rs.getString("email"),
                                    rs.getString("password"),
                                    rs.getString("username"),
                                    rs.getString("numero_torre"),
                                    rs.getString("numero_apartamento"));

            }

            else if (rs.getBoolean(9) == true) {
                return new Admin(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }

            //else return new Vigilante()}

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
