package com.example.frontendcommunityapp;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class UserInterface {

    GridPane loginPage;

    public BorderPane createContent(){
        BorderPane root = new BorderPane();
        root.setPrefSize(680, 400);// Size for the pane
        //root.getChildren().add(loginPage); // Method to add LoginPage(Node as children) to the Pane
        root.setCenter(loginPage);

        return root;
    }

    public UserInterface(){
        createLoginPage(); // When class is instantiated this method is called

    }

    private void createLoginPage(){
        Text userNameText = new Text("Usuario:");
        Text passwordText = new Text("Contraseña:");


        TextField userName = new TextField();
        userName.setPromptText("Escriba su nombre de usuario aquí");
        PasswordField password = new PasswordField();
        password.setPromptText("Escriba su contraseña");

        Button loginButton = new Button("Ingresar");

        loginPage = new GridPane();
        // loginPage.setStyle("-fx-background-color: grey;"); Color
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(10);
        loginPage.setVgap(10);
        loginPage.add(userNameText,0, 0);
        loginPage.add(userName, 1, 0);
        loginPage.add(passwordText, 0, 1);
        loginPage.add(password, 1, 1);
        loginPage.add(loginButton, 1,2);
    }
}
