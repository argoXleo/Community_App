package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.NovedadVigilante;
import com.example.frontendcommunityapp.Model.Services.Queja;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class NovedadesVigilanteController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField idUsuarioField;

    @FXML
    private TextField fechaField;

    @FXML
    private TextField asuntoField;

    @FXML
    private TextArea descripcionField;

    public void registrarNovedad(ActionEvent actionEvent) {
        String fecha = fechaField.getText();
        String asunto = asuntoField.getText();
        String descripcion = descripcionField.getText();
        int idVigilante;

        try {
            idVigilante = Integer.parseInt(idUsuarioField.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "ID de vigilante debe ser un número.");
            return;
        }

        NovedadVigilante novedad = new NovedadVigilante(fecha, asunto, descripcion, idVigilante);
        novedad.registrarNovedadDB();

        mostrarAlerta("Éxito", "Novedad registrada correctamente.");
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

    public void volverAServiciosVigilante(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("ServicesVigilante.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
