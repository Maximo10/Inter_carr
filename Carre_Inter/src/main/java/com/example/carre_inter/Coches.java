package com.example.carre_inter;

public class Coches extends Thread {

    private String nombre;
    private int velocidadMax;
    private int distanciaFin;
    private int distancia = 0;
    private Grand_Prix gp;
    private HelloController controller;
    private int id;

    public Coches(String nombre, int velocidadMax, int distanciaFin, Grand_Prix gp, HelloController controller, int id) {
        this.nombre = nombre;
        this.velocidadMax = velocidadMax;
        this.distanciaFin = distanciaFin;
        this.gp = gp;
        this.controller = controller;
        this.id = id;
    }

    @Override
    public void run() {
        while (distancia < distanciaFin) {
            int avance = (int)(Math.random() * velocidadMax / 3) + 1;
            distancia += avance;
            if (distancia > distanciaFin){
                distancia = distanciaFin;
            }

            double recorrido = 50 + (distancia * 800.0 / distanciaFin);
            controller.moverCoche(id, recorrido);

            try {
                Thread.sleep(100);  // pausa para ver la carrera
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gp.ver_podio(nombre);
    }
}
