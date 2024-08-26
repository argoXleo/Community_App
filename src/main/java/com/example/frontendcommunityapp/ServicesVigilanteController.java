package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicesVigilanteController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchRegistrarVisitantePage(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("RegistrarVisitante.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void salirVigilanteServices(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void ReportarNovedadVigilante(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("NovedadesVigilante.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
