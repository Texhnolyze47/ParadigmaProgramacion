package com.texhnolyze.p1.mascotas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MascotasGui extends JFrame implements ActionListener {

    private final JButton addMascota;
    private final JButton comenzarCarrera;
    private final JTextArea jTextAreaMascota;
    private final JTextArea jTextAreaCarrera;

    private final JTextField jTextFieldNombre;


    private List<Mascota> mascotas = new ArrayList<>();
    private final List<MascotaHilo> hilos = new ArrayList<>();

    public MascotasGui(){
        setLayout(new FlowLayout());
        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        setTitle("carreras interfaz");
        jTextAreaMascota = new JTextArea(5,20);
        jTextAreaMascota.setSize(200,100);
        add(jTextAreaMascota);

        JLabel labelNombre = new JLabel("Nombre: ");
        add(labelNombre);

        jTextFieldNombre = new JTextField(20);
        add(jTextFieldNombre);

        addMascota = new JButton("Agregar mascota");
        addMascota.addActionListener(this);
        add(addMascota);

        comenzarCarrera = new JButton("Carrera");
        comenzarCarrera.addActionListener(this);
        add(comenzarCarrera);

        jTextAreaCarrera = new JTextArea(5,20);
        jTextAreaCarrera.setSize(200,100);
        add(jTextAreaCarrera);

        setSize(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addMascota){
            String nombre = jTextFieldNombre.getText();
            if (!nombre.isEmpty()){
                Mascota mascota = new Mascota();
                mascota.setNombre(nombre);
                mascotas.add(mascota);
                jTextAreaMascota.append(mascota.getNombre() + "\n");
                jTextFieldNombre.setText("");
            }

        }
        if (e.getSource() == comenzarCarrera){
            hilos.clear();
            for(Mascota mascota : mascotas){
                MascotaHilo mascotaHilo = new MascotaHilo(mascota, jTextAreaCarrera);
                hilos.add(mascotaHilo);
            }
            for (MascotaHilo hilo : hilos) {
                Thread thread = new Thread(hilo);
                thread.start();
            }
        } else {
            System.out.println("Algo salio mal");
        }
    }
}
