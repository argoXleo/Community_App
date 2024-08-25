package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Users.Admin;
import com.example.frontendcommunityapp.Model.Users.Resident;
import com.example.frontendcommunityapp.Model.Users.Vigilante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    @FXML
    private Button buttonVolver; // Botón para volver a servicios

    public void registrarUsuario(ActionEvent actionEvent) throws IOException {
        String nombre = textFieldNombre.getText();
        String telefono = textFieldTelefono.getText();
        String email = textFieldEmail.getText();
        String pass = passwordField.getText();
        String username = textFieldUsername.getText();
        String torre = textFieldTorre.getText();
        String apto = textFieldApto.getText();

        if (radioButtonAdmin.isSelected()) {
            Admin bob = new Admin(12, nombre, telefono, email, pass, username, torre, apto);
            bob.registrarAdminDB(nombre, telefono, email, pass, username, torre, apto);
            System.out.println("Admin creado con éxito");
        } else if (radioButtonResident.isSelected()) {
            Resident alex = new Resident(12, nombre, telefono, email, pass, username, torre, apto);
            alex.registrarResidentDB(nombre, telefono, email, pass, username, torre, apto);
            System.out.println("Residente creado con éxito");
        } else if (radioButtonVigilante.isSelected()) {
            Vigilante pedro = new Vigilante(12, nombre, telefono, email, pass, username);
            pedro.registrarVigilanteDB(nombre, telefono, email, pass, username);
            System.out.println("Vigilante creado con éxito");
        }
    }

    @FXML
    public void volverAServicios(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Services.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
