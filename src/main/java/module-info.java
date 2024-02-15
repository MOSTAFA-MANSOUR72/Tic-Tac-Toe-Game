module com.example.xogame {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.xogame to javafx.fxml;
    exports com.example.xogame;
}