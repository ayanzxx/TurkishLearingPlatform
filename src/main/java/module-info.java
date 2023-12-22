module com.example.inf {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.inf to javafx.fxml;
    exports com.example.inf;
}