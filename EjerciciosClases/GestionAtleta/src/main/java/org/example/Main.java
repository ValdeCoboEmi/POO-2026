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

    }
}