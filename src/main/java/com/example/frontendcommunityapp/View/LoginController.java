package com.example.frontendcommunityapp.View;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void handleLoginButtonAction() {
        // Logica del botón
        String username = userNameField.getText();
        String password = passwordField.getText();


        if (authenticateUser(username, password)) {
            System.out.println("Bienvenido, " + username + "!");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }

    private boolean authenticateUser(String username, String password) {

        return true;
    }
}