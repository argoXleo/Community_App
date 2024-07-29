module com.example.frontendcommunityapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.frontendcommunityapp to javafx.fxml;
    exports com.example.frontendcommunityapp;
}