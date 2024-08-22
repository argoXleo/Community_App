package com.example.frontendcommunityapp.Tests;

import com.example.frontendcommunityapp.Model.Services.Pago;
import com.example.frontendcommunityapp.Model.Services.Reservas;
import com.example.frontendcommunityapp.Model.Services.Services;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class ServiceList {

    private TableView<Services> serviceTable;

    private VBox createTable(){

        TableColumn id = new TableColumn("id");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn name = new TableColumn("name");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));

        serviceTable = new TableView<>();

        ObservableList<Services> data = FXCollections.observableArrayList();
        data.add(new Pago(2, "Pago"));
        data.add(new Reservas(4, "Reservas"));

        serviceTable = new TableView<>();
        serviceTable.setItems(data);
        serviceTable.getColumns().addAll(id, name);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(serviceTable);
        return vBox;


    }
}

