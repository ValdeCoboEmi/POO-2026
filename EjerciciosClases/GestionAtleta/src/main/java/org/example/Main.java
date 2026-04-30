package org.example;

import org.example.modelo.Atleta;
import org.example.modelo.Entrenador;
import org.example.modelo.GestorReporte;
import org.example.patrones.estrategia.conversion.ConversionEuros;
import org.example.patrones.estrategia.conversion.ConversionPesosMexicanos;
import org.example.patrones.estrategia.conversion.Planilla;
import org.example.patrones.estrategia.visualizacion.EstrategiaVisualizacion;
import org.example.patrones.estrategia.visualizacion.Reporte;
import org.example.patrones.estrategia.visualizacion.VisualizacionCompleta;
import org.example.patrones.estrategia.visualizacion.VisualizacionSimple;
import org.example.ui.DatosQuemados;
import org.example.ui.EntradaDatosAtleta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final EntradaDatosAtleta entrada = new EntradaDatosAtleta();
    private static final List<Atleta> atletas = new ArrayList<>();

    public static void main(String[] args) {

        //INICIAULZAR
        Reporte reporte1 = new Reporte();
        reporte1.setAsunto("Reporte de Atletas");
        reporte1.setFecha(LocalDate.now());

        EstrategiaVisualizacion reporteCompleta = new VisualizacionCompleta();
        EstrategiaVisualizacion reporteSimple = new VisualizacionSimple();

        reporte1.setEstrategia(reporteCompleta);
        reporte1.setEstrategia(reporteSimple);

        reporte1.visualizar();

        Entrenador entrenador1 = new Entrenador();
        entrenador1.setNombre("Juan Pérez");
        entrenador1.setExperiencia(10);
        GestorReporte gestorReporteEntrenador = new GestorReporte();
        entrenador1.enviarReporte(gestorReporteEntrenador, reporte1);

        System.out.println("\n===== PLANILLA =====");

        // INICIALIZAR CON EUROS
        Planilla planilla = new Planilla(entrenador1, new ConversionEuros());

        //IMPRIMIRI
        System.out.println("Entrenador: " + entrenador1.getNombre());
        System.out.println("Salario Base (USD): $" + planilla.calcularSalarioBase()); //
        System.out.println("Salario convertido a Euros: €" + planilla.convertirSalario());

        // AHORA CON MEXICANOS
        System.out.println("\nConversión a Pesos Mexicanos:");
        planilla.setEstrategia(new ConversionPesosMexicanos());
        System.out.println("Salario convertido a MXN: $" + planilla.convertirSalario());
        System.out.println("===================================================\n");

    /*
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

     */
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