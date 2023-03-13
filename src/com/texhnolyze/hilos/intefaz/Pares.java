package com.texhnolyze.hilos.intefaz;

import javax.swing.*;

public class Pares extends Thread {
    private final JTextArea jTextAreaPares;

    public Pares(JTextArea jTextAreaPares) {
        this.jTextAreaPares = jTextAreaPares;
    }

    @Override
    public void run() {
        int n;
        int contador = 0;
        for (n = 1; n <= 10; n++) {
            if (n % 2 == 0) {
                contador = contador + n;
                jTextAreaPares.append(" " + n + "\n");
            }
        }
        jTextAreaPares.append(" ******************** \n");
        jTextAreaPares.append("La suma de los pares es : "+contador + "\n");
    }
}
