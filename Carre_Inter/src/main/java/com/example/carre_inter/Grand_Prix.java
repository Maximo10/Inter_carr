package com.example.carre_inter;

import javafx.application.Platform;
import javafx.scene.control.Label;
import java.util.ArrayList;
import java.util.List;

public class Grand_Prix {

    private static final List<String> Podio = new ArrayList<>();
    private final Label podioLabel;

    public Grand_Prix(Label podioLabel) {
        this.podioLabel = podioLabel;
    }

    public synchronized void ver_podio(String nombre) {
        Podio.add(nombre);

        if (Podio.size() == 4) {
            StringBuilder sb = new StringBuilder("\nPodio:\n");
            for (int i = 0; i < Podio.size(); i++) {
                String medalla = switch(i) {
                    case 0 -> "🥇"; case 1 -> "🥈"; case 2 -> "🥉"; default -> "🏁";
                };
                sb.append(medalla).append(" Posición ").append(i+1).append(": ").append(Podio.get(i)).append("\n");
            }
            // Mostrar podio en la UI
            Platform.runLater(() -> podioLabel.setText(sb.toString()));
            Podio.clear(); // permitir reiniciar carrera si quieres
        }
    }
}
