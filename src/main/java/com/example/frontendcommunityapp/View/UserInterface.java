package com.example.frontendcommunityapp.View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserInterface {

    public GridPane loginPage;
    public GridPane helloPage;

    public UserInterface(){
        createLoginPage();
        createHelloPage();
    }

    private void createLoginPage(){
        loginPage = new GridPane();
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(10);
        loginPage.setVgap(10);

        Label userNameLabel = new Label("Usuario:");
        loginPage.add(userNameLabel, 0, 0);

        TextField userNameField = new TextField();
        loginPage.add(userNameField, 1, 0);

        Label passwordLabel = new Label("Contraseña:");
        loginPage.add(passwordLabel, 0, 1);

        PasswordField passwordField = new PasswordField();
        loginPage.add(passwordField, 1, 1);

        Button loginButton = new Button("Ingresar");
        loginPage.add(loginButton, 1, 2);
    }

    private void createHelloPage(){
        helloPage = new GridPane();
        helloPage.setAlignment(Pos.CENTER);
        helloPage.setHgap(10);
        helloPage.setVgap(10);

        Label welcomeLabel = new Label("Bienvenido!");
        helloPage.add(welcomeLabel, 0, 0);

        Button helloButton = new Button("Hola!");
        helloPage.add(helloButton, 0, 1);
    }
}