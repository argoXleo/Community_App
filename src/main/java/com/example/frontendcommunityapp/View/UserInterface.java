package com.example.frontendcommunityapp.View;

import com.example.frontendcommunityapp.Controller.Login;
import com.example.frontendcommunityapp.Model.Resident;
import com.mysql.cj.protocol.x.XMessage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class UserInterface {
    @FXML
    private Label messageLabel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    public GridPane loginPage;
    public GridPane helloPage;

    Resident loggedInResident;


    public UserInterface(){
        createLoginPage();
        createHelloPage();
    }

    private void createLoginPage(){
        loginPage = new GridPane();
        loginPage.setAlignment(Pos.CENTER);
        loginPage.setHgap(10);
        loginPage.setVgap(10);

        //Label userNameLabel = new Label("Usuario:");
        //loginPage.add(userNameLabel, 0, 0);

        //TextField userNameField = new TextField();
        //loginPage.add(userNameField, 1, 0);

        //Label passwordLabel = new Label("Contraseña:");
        //loginPage.add(passwordLabel, 0, 1);

        //PasswordField passwordField = new PasswordField();
        //loginPage.add(passwordField, 1, 1);

        //Button loginButton = new Button("Ingresar");
        //loginPage.add(loginButton, 1, 2);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String nombre = userNameField.getText();
                String pass = passwordField.getText();
                Login login = new Login();
                loggedInResident = (Resident) login.userLogin(nombre, pass);
                if(loggedInResident != null){
                    messageLabel.setText("Welcome: " + loggedInResident.getNombre());
                }
                else{
                    messageLabel.setText("Login Failed, provide correct credentialsl");
                }
            }
        });



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