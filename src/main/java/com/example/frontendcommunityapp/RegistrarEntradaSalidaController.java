package com.example.frontendcommunityapp;

import com.example.frontendcommunityapp.Controller.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;

public class RegistrarEntradaSalidaController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField tfDocIdentidadVisitor;

    @FXML
    private Button buttonRegistrarSalida;

    @FXML
    private Button buttonAtrasVigilanteServides;

    @FXML
    private TextField tfEstadoRegistroSalidaEntrada;


    public void atrasVigilanteServices(javafx.event.ActionEvent actionEvent) throws IOException {

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


    public void registrarSalida(ActionEvent actionEvent) {
        String identificacion = tfDocIdentidadVisitor.getText();
        String query ="UPDATE visitante SET isAdentro = false WHERE docIdentidad = '" +identificacion+ "' ";

        DbConnection connection = new DbConnection();
        try {
            int rsInsertData = connection.updateDataBase(query);

        }catch (Exception e){
            e.printStackTrace();
        }

        tfEstadoRegistroSalidaEntrada.setText("Salida registrada");
    }

    public void registrarEntrada(ActionEvent actionEvent) {
        String identificacion = tfDocIdentidadVisitor.getText();
        String query ="UPDATE visitante SET isAdentro = true WHERE docIdentidad = '" +identificacion+ "' ";

        DbConnection connection = new DbConnection();
        try {
            int rsInsertData = connection.updateDataBase(query);

        }catch (Exception e){
            e.printStackTrace();
        }
        tfEstadoRegistroSalidaEntrada.setText("Entrada registrada");
    }
}
