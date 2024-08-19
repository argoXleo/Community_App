package com.example.frontendcommunityapp.Controller;

import java.sql.ResultSet;

public class Login {


    public boolean userLogin(String userName, String password){
        String query = "SELECT * FROM logintest WHERE username = '"+userName+"' AND password = '"+ password+"'";
        DbConnection connection = new DbConnection();
        try {
            ResultSet rs = connection.getQueryTable(query);
            if (rs.next())
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        Login login = new Login();
        System.out.println(login.userLogin("Jack", "1234"));
    }
}
