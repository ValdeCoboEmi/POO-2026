package org.example.patrones.estrategia.visualizacion;

public class VisualizacionCompleta implements EstrategiaVisualizacion{

    public void visualizar(Reporte reporte){
        // Imprimiendo todo la info del reporte
        System.out.println("Visualizacion completa del reporte");
        System.out.println("Asunto :" + reporte.getAsunto());
        System.out.println("Fecha: " + reporte.getFecha());
    }
}
