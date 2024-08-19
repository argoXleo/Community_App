module com.example.frontendcommunityapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.frontendcommunityapp to javafx.fxml;
    exports com.example.frontendcommunityapp;
}