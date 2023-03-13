package com.texhnolyze.hilos.intefaz;

import javax.swing.*;

public class Impares extends Thread {

    private final JTextArea jTextAreaImpares;

    public Impares(JTextArea jTextAreaImpares) {
        this.jTextAreaImpares = jTextAreaImpares;
    }


    @Override
    public void run() {
        int n, c;
        int contador = 0;
        for (n = 1; n <= 10; n++) {
            c = n % 2;
            if (c != 0) {
                contador = contador + n;
                jTextAreaImpares.append(" " + n + "\n");
            }
        }
        jTextAreaImpares.append(" ******************** \n");
        jTextAreaImpares.append("La suma de los impares es : "+contador + "\n");
    }
}
