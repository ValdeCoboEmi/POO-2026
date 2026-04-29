package org.example.patrones.estrategia.visualizacion;

public class VisualizacionSimple implements EstrategiaVisualizacion{

    public void visualizar(Reporte reporte){
        // Imprimiendo todo la info del reporte
        System.out.println("Visualizacion simple    ");
        System.out.println("Asunto :" + reporte.getAsunto());
    }
}
