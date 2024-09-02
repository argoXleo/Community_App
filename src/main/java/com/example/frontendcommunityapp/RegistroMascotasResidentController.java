package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.RegistroMascotas;
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
        // Inicialización si es necesaria
    }

    public void registrarMascota(ActionEvent actionEvent) {
        try {
            String nombre = textFieldNombreMascota.getText();
            String raza = textFieldRaza.getText();
            String idCasaAptoText = textFieldIdCasaApto.getText();

            if (nombre.isEmpty() || raza.isEmpty() || idCasaAptoText.isEmpty()) {
                logger.log(Level.WARNING, "Todos los campos deben ser completados.");
                messageVerifyRegister.setText("Por favor completa todos los campos.");
                return;
            }

            int idUsuario = Integer.parseInt(idCasaAptoText);
            boolean perdido = checkBoxPerdido.isSelected();

            RegistroMascotas registroMascotas = new RegistroMascotas(nombre, raza, idUsuario, perdido);

            // Verificar si la mascota ya está registrada como perdida
            if (registroMascotas.existeMascotaPerdida()) {
                if (!perdido) {
                    // La mascota ha sido encontrada
                    registroMascotas.actualizarMascota();
                    messageVerifyRegister.setText("La mascota ha sido encontrada. Registro guardado exitosamente");
                } else {
                    // La mascota ya está registrada como perdida
                    messageVerifyRegister.setText("La mascota ya está registrada como perdida.");
                }
            } else {
                // La mascota no está registrada como perdida
                registroMascotas.registrarMascota();
                if (perdido) {
                    messageVerifyRegister.setText("La mascota ha sido reportada como perdida." +
                            " En caso de encontrarla por favor actualice el registro");
                } else {
                    messageVerifyRegister.setText("Mascota registrada exitosamente.");
                }
            }

            logger.log(Level.INFO, "Mascota registrada exitosamente.");
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error al convertir el ID de casa/apto a entero.", e);
            messageVerifyRegister.setText("Error al convertir el ID de casa/apto a entero.");
        }
    }

    public void volver(ActionEvent event) throws IOException {
        Stage stageActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        // Cierra la ventana actual
        stageActual.close();

        // Carga la escena de anterior
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ServicesResident.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Crea un nuevo Stage y muestra la escena
        Stage nuevoStage = new Stage();
        nuevoStage.setScene(scene);
        nuevoStage.show();
    }
}
//