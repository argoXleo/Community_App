package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Queja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class QuejasController {

    @FXML
    private TextField fechaField;
    @FXML
    private TextField asuntoField;
    @FXML
    private TextField descripcionField;
    @FXML
    private TextField idUsuarioField;

    @FXML
    private void registrarQueja(ActionEvent actionEvent) {
        String fecha = fechaField.getText();
        String asunto = asuntoField.getText();
        String descripcion = descripcionField.getText();
        int idUsuario;

        try {
            idUsuario = Integer.parseInt(idUsuarioField.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de usuario debe ser un número.");
            return;
        }

        Queja queja = new Queja(fecha, asunto, descripcion, idUsuario);
        queja.registrarQuejaDB();

        mostrarAlerta("Éxito", "Queja registrada correctamente.");
        limpiarCampos();
    }

    private void mostrarAlerta(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void limpiarCampos() {
        fechaField.clear();
        asuntoField.clear();
        descripcionField.clear();
        idUsuarioField.clear();
    }

    private Stage dashboardStage;

    @FXML
    private void volverAServicios(ActionEvent actionEvent) {
        if (dashboardStage == null || !dashboardStage.isShowing()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Services.fxml"));
                Parent root = loader.load();
                dashboardStage = new Stage(); // Crear una nueva instancia de Stage
                dashboardStage.setScene(new Scene(root));
                dashboardStage.show();
                // Cerrar la ventana actual
                ((Stage) ((Node) actionEvent.getSource()).getScene().getWindow()).close();
            } catch (Exception e) {
                e.printStackTrace();
                mostrarAlerta("Error", "No se pudo cargar la vista de servicios.");
            }
        } else {
            // Si ya está abierta, simplemente la traemos al frente
            dashboardStage.toFront();
        }
    }

}


