package com.texhnolyze.hilos;

public class ThreadRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + Thread.currentThread()
                    .getName());
            System.out.println("Termina thread " + Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {
        new Thread(new ThreadRunnable(),"Pepe").start();
        new Thread(new ThreadRunnable(),"Juan").start();
        System.out.println("Termina el thread main");
    }
}
