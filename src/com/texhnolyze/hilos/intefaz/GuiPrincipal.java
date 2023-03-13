package com.texhnolyze.hilos.intefaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiPrincipal extends JFrame implements ActionListener {
    private final JButton button;
    private final JTextArea jTextAreaImpares;
    private final JTextArea jTextAreaPares;
    public GuiPrincipal(){
        setLayout(new FlowLayout());
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        setTitle("hilos interfaz");
        jTextAreaImpares = new JTextArea(5,20);
        jTextAreaImpares.setSize(200,100);
        add(jTextAreaImpares);

        button = new JButton("Iniciar");
        button.addActionListener(this);
        add(button);

        jTextAreaPares = new JTextArea(5,20);
        jTextAreaPares.setSize(200,100);
        add(jTextAreaPares);

        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button){
            Pares eje1 = new Pares(jTextAreaPares);
            eje1.start();
            Impares eje2 = new Impares(jTextAreaImpares);
            eje2.start();
        } else {
            System.out.println("Algo salio mal");
        }
    }
}
