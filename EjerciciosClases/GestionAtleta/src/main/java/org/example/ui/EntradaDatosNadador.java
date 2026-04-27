package org.example.ui;

import org.example.catalogo.Deporte;
import org.example.modelo.*;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class EntradaDatosNadador {
    private Scanner sc;

    public Atleta leerNadador() {
        System.out.println("Ingrese los datos del atleta:");

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        int edad = leerEntero("Edad: ");

        System.out.print("Deporte (NATACION): ");
        Deporte deporte = leerDeporte();

        System.out.print("Peso (kg): ");
        double peso = Double.parseDouble(sc.nextLine());

        System.out.print("Altura (m): ");
        double altura = Double.parseDouble(sc.nextLine());

        // Arreglo de horas (7 días)
        double[] horas = new double[7];
        System.out.println("Ingrese las horas de entrenamiento por cada día:");
        for (int i = 0; i < 7; i++) {
            System.out.print("Día " + (i + 1) + ": ");
            horas[i] = Double.parseDouble(sc.nextLine());
        }

        System.out.print("Estilo de nado: ");
        String estilo = sc.nextLine();

        // Crear objeto
        return new Nadador(
                nombre,
                edad,
                deporte,
                peso,
                altura,
                horas,
                0,
                0,
                estilo
        );
    }

    // ================= VALIDACIONES =================

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    private double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingrese un número válido.");
            }
        }
    }

    private LocalDate leerFecha(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Error: Formato inválido. Use YYYY-MM-DD.");
            }
        }
    }

    private Deporte leerDeporte() {
        while (true) {
            System.out.println("Seleccione el deporte:");

            Deporte[] deportes = Deporte.values();

            for (int i = 0; i < deportes.length; i++) {
                System.out.println((i + 1) + ". " + deportes[i]);
            }

            int opcion = leerEntero("Opción: ");

            if (opcion >= 1 && opcion <= deportes.length) {
                return deportes[opcion - 1];
            } else {
                System.out.println("Error: opción inválida.");
            }
        }
    }
}
