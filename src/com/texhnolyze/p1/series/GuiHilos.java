package com.texhnolyze.p1.series;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiHilos extends JFrame implements ActionListener {

    private final JButton button;
    private final JTextArea jTextAreaSerie;

    public GuiHilos(){
        setLayout(new FlowLayout());
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        setTitle("hilos series");
        jTextAreaSerie = new JTextArea(5,20);
        jTextAreaSerie.setSize(200,100);
        add(jTextAreaSerie);

        button = new JButton("Iniciar");
        button.addActionListener(this);
        add(button);

        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            HilosSerie serie = new HilosSerie(jTextAreaSerie);
            Thread hilo = new Thread(serie);
            hilo.start();
        } else {
            System.out.println("Algo salio mal");
        }
    }
}
