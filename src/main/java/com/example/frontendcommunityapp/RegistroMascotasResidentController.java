package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistroMascotasResidentController {
    private static final Logger logger = Logger.getLogger(RegistroMascotasResidentController.class.getName());

    @FXML
    private TextField textFieldNombreMascota;

    @FXML
    private TextField textFieldRaza;

    @FXML
    private TextField textFieldIdCasaApto;

    @FXML
    private CheckBox checkBoxPerdido;

    @FXML
    private TextField messageVerifyRegister;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {

    }


    public void registrarMascota(ActionEvent actionEvent) {
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

        messageVerifyRegister.setText("Mascota Registrada");
    }

    public void volverAServiciosResident(ActionEvent event) throws IOException {
        // Obtén el Stage de la ventana actual
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();

        // Cierra la ventana actual
        stageActual.close();

        // Carga la escena de "ServicesResident.fxml"
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Crea un nuevo Stage y muestra la escena
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();
    }
}
