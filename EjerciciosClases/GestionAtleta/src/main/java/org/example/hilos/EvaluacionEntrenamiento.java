package org.example.hilos;


import org.example.modelo.Atleta;
import org.example.modelo.Entrenador;
import org.example.modelo.GestorReporte;
import org.example.patrones.estrategia.visualizacion.Reporte;

// Implementar de la interfaz Runnable
public class EvaluacionEntrenamiento implements Runnable {

    // Crear el atributo que referencia a la clase atleta y el entrenador
    Atleta atleta;
    Entrenador entrenador;
    Reporte reporte;
    GestorReporte gestorReporte;

    // Constructor
    public EvaluacionEntrenamiento(Atleta atleta, Entrenador entrenador) {
        this.atleta = atleta;
        this.entrenador = entrenador;
    }

    public EvaluacionEntrenamiento(Atleta atleta, Entrenador entrenador, Reporte reporte, GestorReporte gestorReporte) {
        this.atleta = atleta;
        this.entrenador = entrenador;
        this.reporte = reporte;
        this.gestorReporte = gestorReporte;
    }

    //Sobreescribir el metodo run()
    @Override
    public void run() {
        String atletaAsignado = entrenador.obtenerAtletaPorNombre(atleta).getNombre();
        // Imprimir nombre del entrenador y el atleta que esta evaluando
        System.out.println("\nEl entrenador " + entrenador.getNombre());
        System.out.println("Evaluacion del atelta" + atletaAsignado);

        // Simula evaluación cada 5 segundos por la cantidad de ejercicios
        for (var ejercicios : atleta.getPlanActual().getEjerciciosDuracion().entrySet()) {
            System.out.println("Evaluando el ejercicio: " + ejercicios.getKey());
            try {
                Thread.sleep((long) ((ejercicios.getValue() * 60 * 100)+3)); // Simula el tiempo de evaluación tomando en cuenta que ha terminado
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("La evaluación ha sido interrumpida");
            }
        }

        // Texto que indica que el entrenador esta generando la retroalimentacion
        System.out.println("Realizando la retroalimentacion del entrenamiento del atleta " + atleta.getNombre());


        //Invocar metodos de firmarReporte y guardarReportes
        reporte.firmarReporte("Atelta [" + atletaAsignado +"]");
        reporte.firmarReporte(" Entrenador [" + entrenador.getNombre() + "]\n");


    }
}