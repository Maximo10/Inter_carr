package com.example.carre_inter;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML private Label car1, car2, car3, car4, podioLabel;
    @FXML private javafx.scene.control.Button startButton;

    private final int META = 1000;

    public void moverCoche(int id, double recorido) {
        Platform.runLater(() -> {
            switch (id) {
                case 1 -> car1.setLayoutX(recorido);
                case 2 -> car2.setLayoutX(recorido);
                case 3 -> car3.setLayoutX(recorido);
                case 4 -> car4.setLayoutX(recorido);
            }
        });
    }

    @FXML
    public void iniciarCarrera() {
        startButton.setDisable(true); // desactivar botón mientras corre la carrera
        podioLabel.setText(""); // limpiar podio

        Grand_Prix gp = new Grand_Prix(podioLabel);

        new Coches("Ferrari 🚗", 150, META, gp, this, 1).start();
        new Coches("Lamborghini 🏎️", 180, META, gp, this, 2).start();
        new Coches("Porsche 🚙", 160, META, gp, this, 3).start();
        new Coches("McLaren 🚕", 170, META, gp, this, 4).start();
    }
}
