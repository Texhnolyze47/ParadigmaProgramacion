package com.texhnolyze.p1.mascotas;

import javax.swing.*;

public class MascotaHilo implements Runnable{

    private final Mascota mascota;
    private final JTextArea jTextArea;


    public MascotaHilo(Mascota mascota, JTextArea jTextArea) {
        this.mascota = mascota;
        this.jTextArea = jTextArea;
    }

    @Override
    public void run() {
        int distanciaTotal = 30;
        int dinstanciaRecorrida = 0;
        jTextArea.append(mascota.getNombre() + " ha comenzado. \n");

        while (dinstanciaRecorrida < distanciaTotal){
            int distanciaAvance = (int) (Math.random() * 10) + 1;
            dinstanciaRecorrida += distanciaAvance;
            jTextArea.append(mascota.getNombre() + " ha avanzado " + distanciaAvance
                    + " metros. Distancia total recorrida: " + dinstanciaRecorrida + " metros.\n");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        jTextArea.append(mascota.getNombre() + " ha terminado la carrera!\n");
    }
}
