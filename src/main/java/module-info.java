module com.example.listapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.listapp to javafx.fxml;
    exports com.example.listapp;
}