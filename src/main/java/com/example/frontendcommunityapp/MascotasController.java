package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;

public class MascotasController {
    private static final Logger logger = Logger.getLogger(MascotasController.class.getName());

    @FXML
    private TextField textFieldNombreMascota;
    @FXML
    private TextField textFieldRaza;
    @FXML
    private TextField textFieldIdCasaApto;
    @FXML
    private CheckBox checkBoxPerdido;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {

    }

    @FXML
    public void registrarMascota() {
        try {
            String nombre = textFieldNombreMascota.getText();
            String raza = textFieldRaza.getText();
            String idCasaAptoText = textFieldIdCasaApto.getText();

            if (nombre.isEmpty() || raza.isEmpty() || idCasaAptoText.isEmpty()) {
                logger.log(Level.WARNING, "Todos los campos deben ser completados.");
                return;
            }

            int idUsuario = Integer.parseInt(idCasaAptoText);
            boolean perdido = checkBoxPerdido.isSelected();

            RegistroMascotas registro = new RegistroMascotas(nombre, raza, idUsuario, perdido);
            registro.registrarMascota();

            System.out.println("RegistroMascotas registrada: " + nombre);
        } catch (NumberFormatException e) {
            logger.log(Level.WARNING, "ID de usuario no válido.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error al registrar mascota", e);
        }
    }

    @FXML
    public void volverAServicios(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Services.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}