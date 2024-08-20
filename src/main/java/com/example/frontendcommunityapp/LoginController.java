package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.Login;
import com.example.frontendcommunityapp.Model.Resident;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    Resident loggedInResident;

    @FXML
    private Label mylabel;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void handleLoginButtonAction() {
        String nombre = userNameField.getText();
        String pass = passwordField.getText();
        Login login = new Login();
        loggedInResident = (Resident) login.userLogin(nombre, pass);
        if (loggedInResident != null) {
            mylabel.setText("Welcome: " + loggedInResident.getNombre());
        } else {
            mylabel.setText("Login Failed, provide correct credentials");
        }

    }
        // Logica del botón
        /*
        String username = userNameField.getText();
        String password = passwordField.getText();


        if (authenticateUser(username, password)) {
            System.out.println("Bienvenido, " + username + "!");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    } */

    private boolean authenticateUser(String username, String password) {

        return true;
    }

}