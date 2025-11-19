module com.example.carre_inter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.carre_inter to javafx.fxml;
    exports com.example.carre_inter;
}