package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Pago;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;




import java.awt.*;
import java.io.IOException;

public class PagosController {

    @FXML
    private TextField textFieldCantidad;

    @FXML
    private TextField textFieldConcepto;

    @FXML
    private TextField textFieldUsername;

    @FXML
    private Button buttonPagar;

    @FXML
    public void registerPaymentInfo(javafx.event.ActionEvent actionEvent) throws IOException {

        String cantidad = textFieldCantidad.getText();
        String concepto = textFieldConcepto.getText();
        String username = textFieldUsername.getText();

        //Resident resident1 = new Resident(1, "Alex", "234312", "@algo");
        Pago pago1 = new Pago(3, "Pago", cantidad, concepto, username);
        pago1.registrarPagoDB(cantidad,concepto,username);


    }
}
