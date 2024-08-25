package com.example.frontendcommunityapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ServicesAdminController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToPagosPage(ActionEvent actionEvent) {
        try {
            root  = FXMLLoader.load(getClass().getResource("PagosAdmin.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }



    public void switchToAdminDashboard(ActionEvent actionEvent) {
        try {
            root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
