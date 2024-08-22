package com.example.frontendcommunityapp;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class DashboardController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    private Button serviceButton;

/*
    public void switchToServicesPage(ActionEvent event) throws IOException {
        root  = FXMLLoader.load(getClass().getResource("Services.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
*/
    public void switchToServicesPage(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            root  = FXMLLoader.load(getClass().getResource("Services.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
