package com.example.frontendcommunityapp;

import java.sql.*;

public class DbConnection {

    private final String dbUrl = "jdbc:mysql://localhost:3306/communityappdb";

    private final String userName = "root";

    private final String password = "_3GTh=FB<s{7l6B";

    private Statement getStatement(){
        try {
            Connection connection = DriverManager.getConnection(dbUrl, userName, password);
            return connection.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet getQueryTable(String query){
        try {
            Statement statement = getStatement();
            return statement.executeQuery(query);
        }catch (Exception e){
            e.printStackTrace();

        }

        return null;
    }

    public static void main(String[] args) {
        DbConnection conn = new DbConnection();

        ResultSet rs = conn.getQueryTable("SELECT * FROM usuarios");
        if (rs != null){
            System.out.println("Connection Successful");
        }
        else {
            System.out.println("Connection Failed ");
        }
    }

}
