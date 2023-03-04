package com.texhnolyze.hilos;

public class ThreadEjemplo extends Thread {
    public ThreadEjemplo(String str) {
        super(str);
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Terminal Thread " + getName());
        }
    }

    public static void main(String[] args) {
        new ThreadEjemplo("Pepe").start();
        new ThreadEjemplo("Juan").start();
        System.out.println("Termina thread main");
    }
}