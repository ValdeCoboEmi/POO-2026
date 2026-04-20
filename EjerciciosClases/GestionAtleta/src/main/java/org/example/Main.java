package org.example;

import org.example.catalogo.Deporte;
import org.example.modelo.Entrenador;
import org.example.modelo.Equipo;
import org.example.modelo.Nadador;

public class Main {
    public static void main(String[] args) {

        Nadador nadador1 = new Nadador("Florencia", 20, Deporte.NATACION,
                55, 1.70, new double[]{2, 4, 6, 7, 3, 5, 2},
                0.0, 0.0, "Mariposa");

        nadador1.imprimir();
        // estableciendo el promHorasCalculadas
        nadador1.setPromHorasEntrenamiento(nadador1.calcularPromedioSemanalEntrenamiento());
        nadador1.cambiarEstilo("Libre (Crol)");
        // estableciendo el imc calculado
        nadador1.setImc(nadador1.calcularIMC());
        System.out.print("Clasificación del IMC: ");
        nadador1.clasificarIMC();
        System.out.print("Clasificación del rendimiento: ");
        nadador1.clasificarRendimiento();
        nadador1.entrenar();

        Nadador nadador2 = new Nadador("Federico", 25, Deporte.NATACION,
                80, 1.85, new double[]{3, 5, 7, 8, 4, 6, 3},
                0.0, 0.0, "Espalda");

        // Crear el equipo
        Equipo equipo1 = new Equipo();
        equipo1.setNombreEquipo("El pepe");
        equipo1.agregarMiembro(nadador1);
        equipo1.agregarMiembro(nadador2);
        equipo1.imprimir();


        System.out.println("\nDatos del entrenador: ");
        // Crear al entrenador
        Entrenador entrenador1 = new Entrenador("Julio", 4);
        System.out.println("Salario del entrenador $: " + entrenador1.calcularSalario());
        entrenador1.imprimir();


        // Determinar el objetivo del plan de entrenamiento

        // Crear el plan de entrenamiento

        // Agregar los datos del plan de entrenamiento, objetivos y ejercicios

        // preescribir plan de entrenamiento al atleta

        // Imprimiendo el plan de entrenamiento asignado a un atleta

    }
}
