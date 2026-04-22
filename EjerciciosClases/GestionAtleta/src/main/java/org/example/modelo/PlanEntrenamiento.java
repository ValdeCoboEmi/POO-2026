package org.example.modelo;

import java.util.HashMap;
import java.util.Map;

public class PlanEntrenamiento implements Imprimible {

    // atributos
    private Map<String, Double> ejerciciosDuracion;
    private String objetivo;

    // constructores
    public PlanEntrenamiento(){
        this.ejerciciosDuracion = new HashMap<>();
    }

    public PlanEntrenamiento(String objetivo) {
        this.ejerciciosDuracion = new HashMap<>();
        this.objetivo = objetivo;
    }

    // setter/getter
    public Map<String, Double> getEjerciciosDuracion() {
        return ejerciciosDuracion;
    }


    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }


    // metodos
    public boolean agregarEjercicios(String nombre, double duracion){
        ejerciciosDuracion.put(nombre, duracion);
        return true;
    }


    @Override
    public void imprimir() {
        System.out.println("Plan de Entrenamiento:");
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Ejercicios y Duración:");
        for (Map.Entry<String, Double> entry : ejerciciosDuracion.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " minutos");
        }
    }

}
