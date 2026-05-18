package org.example.hilos;


import org.example.modelo.Atleta;
import org.example.modelo.Entrenador;

// Implementar de la interfaz Runnable
public class EvaluacionEntrenamiento implements Runnable {

    // Crear el atributo que referencia a la clase atleta y el entrenador
    Atleta atleta;
    Entrenador entrenador;

    // Constructor
    public EvaluacionEntrenamiento(Atleta atleta, Entrenador entrenador) {
        this.atleta = atleta;
        this.entrenador = entrenador;
    }


    //Sobreescribir el metodo run()
    @Override
    public void run() {
        // Imprimir nombre del entrenador y el atleta que esta evaluando
        System.out.println("\nEl entrenador " + entrenador.getNombre());
        System.out.println("Evaluacion del atelta" + entrenador.obtenerAtletaPorNombre(atleta).getNombre());

        // Simula evaluación cada 5 segundos por la cantidad de ejercicios
        for (var ejercicios : atleta.getPlanActual().getEjerciciosDuracion().entrySet()) {
            System.out.println("Evaluando el ejercicio: " + ejercicios.getKey());
            try {
                Thread.sleep(5000); // Simula el tiempo de evaluación
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("La evaluación ha sido interrumpida");
            }
        }

        // Texto que indica que el entrenador esta generando la retroalimentacion
        System.out.println("Realizando la retroalimentacion del entrenamiento del atleta " + atleta.getNombre());

    }
}