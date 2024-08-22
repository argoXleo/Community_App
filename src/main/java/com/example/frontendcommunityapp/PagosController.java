package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Model.Services.Pago;
import com.example.frontendcommunityapp.Model.Users.Resident;
import javafx.event.ActionEvent;


import java.awt.*;
import java.io.IOException;

public class PagosController {

    private Pago pago;

    private TextField textFieldCantidad;
    private TextField textFieldConcepto;
    private TextField textFieldUsername;


    public void registerPaymentInfo(javafx.event.ActionEvent actionEvent) throws IOException {

        double cantidad = Double.parseDouble(textFieldCantidad.getText());
        String concepto = textFieldConcepto.getText();
        String username = textFieldUsername.getText();

        //Resident resident1 = new Resident(1, "Alex", "234312", "@algo");
        Pago pago1 = new Pago(3,"Pago",cantidad, concepto, username);

    }
}
