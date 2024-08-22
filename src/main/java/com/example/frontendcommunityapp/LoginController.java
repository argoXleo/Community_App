package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.Login;
import com.example.frontendcommunityapp.Model.Users.Resident;
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

public class LoginController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Resident loggedInResident;

    @FXML
    private Label mylabel;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    public void handleLoginButtonAction(javafx.event.ActionEvent actionEvent) throws IOException {
        String nombre = userNameField.getText();
        String pass = passwordField.getText();
        Login login = new Login();
        loggedInResident = (Resident) login.userLogin(nombre, pass);
        if (loggedInResident != null) {
            mylabel.setText("Welcome: " + loggedInResident.getNombre());
            try {
                root  = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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