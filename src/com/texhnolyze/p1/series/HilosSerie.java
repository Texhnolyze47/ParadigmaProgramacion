package com.texhnolyze.p1.series;

import javax.swing.*;

public class HilosSerie implements Runnable {

    private final  JTextArea jTextArea;

    public HilosSerie(JTextArea jTextArea) {
        this.jTextArea = jTextArea;
    }

    @Override
    public void run() {
        for (int i = 1; i < 21; i++) {
            jTextArea.append(i + " ,");
        }
    }
}
