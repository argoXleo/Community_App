package com.example.frontendcommunityapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class DashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button serviceButton;

    @FXML
    private void switchToServicesPage(javafx.event.ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Services.fxml"));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void abrirRegistroMascotas(javafx.event.ActionEvent actionEvent) {
        System.out.println("Botón de Registro de Mascotas presionado");
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RegistroMascotas.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registro de Mascotas");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleDashboard(javafx.event.ActionEvent actionEvent) {
        System.out.println("Botón de Dashboard presionado");
    }

    @FXML
    private void handleExit(javafx.event.ActionEvent actionEvent) {
        System.out.println("Botón de Salir presionado");
        // Cerrar la aplicación
        System.exit(0);
    }
}