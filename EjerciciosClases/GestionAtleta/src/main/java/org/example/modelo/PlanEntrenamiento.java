package org.example.modelo;

import java.util.HashMap;
import java.util.Map;

public class PlanEntrenamiento implements Imprimible {

    // atributos
    // Ejercicios - duracion en minutos
    private Map<String, Double> ejerciciosDuracion;
    private String objetivo;

    // constructores
    public PlanEntrenamiento() {
        ejerciciosDuracion = new HashMap<String, Double>();
    }

    public PlanEntrenamiento(Map<String, Double> ejerciciosDuracion, String objetivo) {
        this.ejerciciosDuracion = ejerciciosDuracion;
        this.objetivo = objetivo;
    }

    // setter/getter
    public Map<String, Double> getEjerciciosDuracion() {
        return ejerciciosDuracion;
    }

    /*    public void setEjerciciosDuracion(Map<String, Double> ejerciciosDuracion) {
            this.ejerciciosDuracion = ejerciciosDuracion;
        }*/
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }


    // metodos
    public boolean agregarEjerciciosDuracion(String nombre, Double duracion) {
        return ejerciciosDuracion.put(nombre, duracion) == null;
    }


    @Override
    public void imprimir() {
        System.out.println("\nDetalles del plan de entrenamiento");
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Ejercicios - duración: ");
        // Como iterar el map con el for
        for (Map.Entry<String, Double> entry : ejerciciosDuracion.entrySet()) {
            System.out.println(" -Ejercicios " + entry.getKey() + " minutos:  " + entry.getValue());
        }

    }

}