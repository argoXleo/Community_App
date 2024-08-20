module com.example.frontendcommunityapp.View {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.java;


    opens com.example.frontendcommunityapp to javafx.fxml;
    //exports com.example.frontendcommunityapp;
    exports com.example.frontendcommunityapp.Controller;
    opens com.example.frontendcommunityapp.Controller to javafx.fxml;
    exports com.example.frontendcommunityapp.View;
    opens com.example.frontendcommunityapp.View to javafx.fxml;
    exports com.example.frontendcommunityapp;
}