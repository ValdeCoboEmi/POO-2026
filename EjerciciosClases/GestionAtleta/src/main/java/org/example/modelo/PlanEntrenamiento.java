package org.example.modelo;

import java.util.HashMap;
import java.util.Map;

public class PlanEntrenamiento implements Imprimible {

    // atributos
    private Map<String, Double> ejerciciosDuracion;
    private String objetivo;

    // constructores
    public PlanEntrenamiento() {
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
    public boolean agregarEjercicios(String nombre, double duracion) {
        try {
            if (nombre == null || nombre.isEmpty()) {
                throw new IllegalArgumentException("El nombre del ejercicio no puede ser nulo o vacío.");
            } else if (duracion <= 0) {
                throw new IllegalArgumentException("La duración del ejercicio debe ser mayor a cero.");
            }

            ejerciciosDuracion.put(nombre, duracion);
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar ejercicio: " + e.getMessage());
            return false;
        }
    }


    @Override
    public void imprimir() {
        System.out.println("\nPlan de Entrenamiento:");
        System.out.println("Objetivo: " + objetivo);
        System.out.println("Ejercicios y Duración:");
        for (Map.Entry<String, Double> e : ejerciciosDuracion.entrySet()) {
            System.out.println("- " + e.getKey() + ": " + e.getValue() + " minutos");
        }
    }

}
