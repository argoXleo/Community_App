package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Pago;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;


import java.io.IOException;

public class PagosResidentController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField textFieldCantidad;

    @FXML
    private TextField textFieldConcepto;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private TextField textFieldEstadoPago;

    @FXML
    private Button buttonPagar;

    @FXML
    private Button buttonAtrasPagar;

    @FXML
    public void registerPaymentInfo(javafx.event.ActionEvent actionEvent) throws IOException {

        String cantidad = textFieldCantidad.getText();
        String concepto = textFieldConcepto.getText();
        String username = textFieldUsername.getText();

        //Resident resident1 = new Resident(1, "Alex", "234312", "@algo");
        Pago pago1 = new Pago(3, "Pago", cantidad, concepto, username);
        pago1.registrarPagoDB(cantidad,concepto,username);

        textFieldEstadoPago.setText("Pago Realizado");
    }


    public void backToServicesResident(javafx.event.ActionEvent actionEvent) throws IOException {
        try {
            root = FXMLLoader.load(getClass().getResource("Services.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
