package org.example;

import org.example.modelo.Atleta;
import org.example.ui.DatosQuemados;
import org.example.ui.EntradaDatosNadador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final EntradaDatosNadador entrada = new EntradaDatosNadador();
    private static final List<Atleta> atletas = new ArrayList<>();

    public static void main(String[] args) {

        mostrar();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> registrarNadador();
                case 2 -> mostrarAtletas();
                case 3 -> entrenarAtletas();
                case 4 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        sc.close();
    }

    // ================= MÉTODOS =================

    private static void mostrar() {
        System.out.println("DATOS QUEMADOS\n");
        DatosQuemados.datosquemados();
        System.out.println("\nDATOS PARA INGRESAR\n");
    }

    private static void mostrarMenu() {
        System.out.println("\n===== MENÚ PRINCIPAL =====");
        System.out.println("1. Registrar Nadador");
        System.out.println("2. Mostrar Atletas");
        System.out.println("3. Entrenar Atletas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Error. Ingrese un número válido: ");
            }
        }
    }

    private static void registrarNadador() {
        Atleta nadador = entrada.leerNadador();
        atletas.add(nadador);
        System.out.println("Nadador registrado correctamente.");
    }

    private static void mostrarAtletas() {
        if (atletas.isEmpty()) {
            System.out.println("No hay atletas registrados.");
            return;
        }

        System.out.println("\n=== LISTA DE ATLETAS ===");
        atletas.forEach(a -> {
            a.imprimir();
            System.out.println("----------------------");
        });
    }

    private static void entrenarAtletas() {
        if (atletas.isEmpty()) {
            System.out.println("No hay atletas para entrenar.");
            return;
        }

        atletas.forEach(Atleta::entrenar);
    }
}