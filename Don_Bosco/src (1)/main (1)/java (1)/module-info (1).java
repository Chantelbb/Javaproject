module com.example.don_bosco {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.don_bosco to javafx.fxml;
    exports com.example.don_bosco;
}