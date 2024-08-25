package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.DbConnection;
import com.example.frontendcommunityapp.Controller.Login;
import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.Vigilante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Admin loggedInAdmin;
    private Vigilante loggedVigilante;

    @FXML
    private Label mylabel;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button registroButton;

    @FXML
    public void handleLoginButtonAction(javafx.event.ActionEvent actionEvent) throws IOException, SQLException {
        String nombre = userNameField.getText();
        String pass = passwordField.getText();





        /*
        String query = "SELECT * FROM usuarios WHERE Resident= '1' ";

        DbConnection connection = new DbConnection();
        ResultSet rs = connection.getQueryTable(query);

        && rs.getString("Resident") == "1"

        DbConnection connection = new DbConnection();
        String query = "SELECT Resident FROM usuarios WHERE Resident ='1'";
        try {
            ResultSet rs = connection.getQueryTable(query);
            System.out.println(rs.getString("Resident"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        */


        //Login login = new Login();
        String query = "SELECT * FROM usuarios WHERE username = '" + nombre + "' AND password = '" + pass + "'";
        DbConnection connection = new DbConnection();
        try {

            ResultSet rs = connection.getQueryTable(query);
            rs.next();
            if (rs.getBoolean(10) == true) {
                Resident loggedInResident = new Resident(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));

                try {
                    root = FXMLLoader.load(getClass().getResource("ServicesResident.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } else if (rs.getBoolean(9) == true) {
                Admin loggedInAdmin = new Admin(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));


                try {
                    root  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        /*
        if (  ){



            mylabel.setText("Welcome: " + loggedInResident.getNombre());
            try {
                root  = FXMLLoader.load(getClass().getResource("ServicesResident.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        else if (rs.getBoolean(9) == true) {
            Login loginAdmin = new Login();
            Admin loggedInAdmi                                  n = (Admin) loginAdmin.userLogin(nombre,pass);
            mylabel.setText("Welcome: " + loggedInAdmin.getNombre());
            try {
                root  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        */
            else {
                mylabel.setText("Login Failed, provide correct credentials");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
        public void switchRegisterPage(javafx.event.ActionEvent actionEvent) throws IOException {
            try {
                root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


}

