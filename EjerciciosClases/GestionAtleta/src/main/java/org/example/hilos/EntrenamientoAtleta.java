package org.example.hilos;

import org.example.modelo.Atleta;

// Implementar de la interfaz Runnable
public class EntrenamientoAtleta implements Runnable {

    // Crear el atributo que referencia a la clase atleta
    Atleta atleta;

    // Constructor
    public EntrenamientoAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    //Sobreescribir el metodo run()
    @Override
    public void run() {

        // Texto que imprima quien esta desarrollando el entrenamiento
        System.out.println("El atleta " + atleta.getNombre() + " esta desarrollando su entrenamiento...");

        // Ejecuta la lógica del atleta del metodo entrenar (usa el plan internamente)
        atleta.entrenar();

        // Sumar  la duración total del plan de entrenamiento
        double duractionTotal = 0;

        for (var ejercicios : atleta.getPlanActual().getEjerciciosDuracion().entrySet()) {
            duractionTotal += ejercicios.getValue();
            try {
                Thread.sleep((long) (ejercicios.getValue() * 60 * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("El entramiento ha sido interrumpido");
            }
            System.out.println("Ha finalizado el ejercicio: " + ejercicios.getKey());

        }

        /* Simulación del  tiempo total del entrenamiento
        try {
            Thread.sleep((long) duractionTotal * 60 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("El entramiento ha sido interrumpido");
        }
        */
        System.out.println("El entranimiento ha finalizado......");
    }

}