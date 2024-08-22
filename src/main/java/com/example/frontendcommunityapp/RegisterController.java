package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.User;
import com.example.frontendcommunityapp.Model.Users.Vigilante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField textFieldNombre;

    @FXML
    private TextField textFieldTelefono;

    @FXML
    private TextField textFieldEmail;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldTorre;

    @FXML
    private TextField textFieldApto;

    @FXML
    private RadioButton radioButtonAdmin;

    @FXML
    private RadioButton radioButtonResident;

    @FXML
    private RadioButton radioButtonVigilante;

    @FXML
    private Button buttonRegistrar;

    boolean isSelected = false;








    public void registrarUsuario(javafx.event.ActionEvent actionEvent) throws IOException {

        String nombre = textFieldNombre.getText();
        String telefono = textFieldTelefono.getText();
        String email = textFieldEmail.getText();
        String pass = passwordField.getText();
        String username = textFieldUsername.getText();
        String torre = textFieldTorre.getText();
        String apto = textFieldApto.getText();

        //Hay que oprimir el botón primero y luego seleccionar tipo de usuario
        radioButtonAdmin.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // RadioButton is now selected
                System.out.println("RadioButton is selected.");
                Admin bob = new Admin(12, nombre,
                        telefono, email, pass, username, torre, apto );

                bob.registrarAdminDB(nombre, telefono, email, pass, username, torre, apto);
                System.out.println("Admin creado con éxtio");
            } else {
                // RadioButton is now deselected
                System.out.println("RadioButton is deselected.");
            }
        });

        radioButtonResident.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // RadioButton is now selected
                System.out.println("RadioButton is selected.");
                Resident alex = new Resident(12, nombre,
                        telefono, email, pass, username, torre, apto );

                alex.registrarResidentDB(nombre, telefono, email, pass, username, torre, apto);
                System.out.println("Residente creado con éxtio");
            } else {
                // RadioButton is now deselected
                System.out.println("RadioButton is deselected.");
            }
        });


        radioButtonVigilante.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // RadioButton is now selected
                System.out.println("RadioButton is selected.");
                Vigilante pedro = new Vigilante(12, nombre,
                        telefono, email, pass, username);

                pedro.registrarVigilanteDB(nombre, telefono, email, pass, username);
                System.out.println("Vigilante creado con éxtio");
            } else {
                // RadioButton is now deselected
                System.out.println("RadioButton is deselected.");
            }
        });







    }
}

