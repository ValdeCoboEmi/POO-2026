package org.example.ui;

import org.example.catalogo.Deporte;
import org.example.hilos.EntrenamientoAtleta;
import org.example.hilos.EvaluacionEntrenamiento;
import org.example.modelo.*;
import org.example.modelo.GestorReporte;
import org.example.patrones.estrategia.visualizacion.EstrategiaVisualizacion;
import org.example.patrones.estrategia.visualizacion.Reporte;
import org.example.patrones.estrategia.visualizacion.VisualizacionCompleta;
import org.example.patrones.estrategia.visualizacion.VisualizacionSimple;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DatosQuemados {
    public static void cargarDatos() {
        Nadador nadador1 = new Nadador("Florencia", 20, Deporte.NATACION,
                55, 1.70, new double[]{2, 4, 6, 7, 3, 5, 2},
                0.0, 0.0, "Mariposa");

        nadador1.imprimir();
        // estableciendo el promHorasCalculadas
        nadador1.setPromHorasEntrenamiento(nadador1.calcularPromedioSemanalEntrenamiento());
        nadador1.cambiarEstilo("Libre (Crol)");
        // estableciendo el imc calculado
        nadador1.setImc(nadador1.calcularIMC());
        // estableciendo la clasificacion IMC
        nadador1.setClasificacionIMC(nadador1.clasificarIMC());
        System.out.print("\nClasificación del IMC: " + nadador1.getClasificacionIMC());
        System.out.print("\nClasificación del rendimiento: ");
        nadador1.clasificarRendimiento();
        nadador1.entrenar();

        // Atleta2
        Atleta nadador2 = new Nadador();
        nadador2.setNombre("Jairo");

        List<Atleta> listaMiembrosEquipos;
        listaMiembrosEquipos = new ArrayList<>();
        // Crear el equipo
        Equipo equipo1 = new Equipo("Tigres", listaMiembrosEquipos);
        equipo1.agregarMiembroEquipo(nadador1);
        equipo1.agregarMiembroEquipo(nadador2);
        equipo1.imprimir();

        Equipo equipo2 = new Equipo();
        equipo2.setNombre("Tigres");
        equipo2.agregarMiembroEquipo(nadador2);
        equipo2.imprimir();


        // Crear al entrenador
        Entrenador entrenador1 = new Entrenador("Julio", 4);

        //Crear entrnador 2
        Entrenador entrenador2 = new Entrenador("Martinez", 4);

        System.out.println("\nDatos del entrenador: ");
        System.out.println("Salario del entrenador $: " + entrenador1.calcularSalario());

        // Agregar atletas al entrenador
        entrenador1.agregarAtleta(nadador1);
        entrenador1.agregarAtleta(nadador2);

        entrenador2.agregarAtleta(nadador1);

        entrenador1.imprimir();

        // Plan de entrenamiento
        PlanEntrenamiento plan1 = new PlanEntrenamiento();

        // Determinar el objetivo del plan de entrenamiento para el nadador1
        String objetivoGenerado = entrenador1.determinarObjetivoPlan(nadador1);
        plan1.setObjetivo(objetivoGenerado);
        System.out.println("\nObjetivo generado para plan de entrenamiento: " + objetivoGenerado + " - Atleta: " + nadador1.getNombre());

        // Agregar ejercicios al plan despues de conocer el objetivo
        plan1.agregarEjerciciosDuracion("Bicicleta", 0.005);
        plan1.agregarEjerciciosDuracion("Flexiones", 0.04);
        plan1.imprimir();

        // preescribir plan de entrenamiento al atleta
        entrenador1.preescribirPlan(nadador1, plan1);
        entrenador2.preescribirPlan(nadador1, plan1);


        // Imprimiendo el plan de entrenamiento asignado a un atleta
        System.out.println("\nPlan de entrenamiento actual del atleta: " + nadador1.getNombre());
        nadador1.getPlanActual().imprimir();

        //Creando el reporte
        Reporte reporte1 = new Reporte();
        reporte1.setAsunto("Primer reporte del mes del atleta " + entrenador1.getAtletasAsignados().get(0).getNombre());
        reporte1.setFecha(LocalDate.now());

        // Enviando reporte por entrenador1
        GestorReporte gestorReporte1 = new GestorReporte();
        entrenador1.enviarReporte(gestorReporte1, reporte1);


        // visualizando el reporte aplicando el patron strategy
        EstrategiaVisualizacion estrategiaReporteCompleto = new VisualizacionCompleta();
        EstrategiaVisualizacion estrategiaReporteSimple = new VisualizacionSimple();
        reporte1.setEstrategia(estrategiaReporteCompleto);
        reporte1.visualizar();

        // Imprimir el listado de los reportes desde el gestor
        System.out.println("\nListado de reportes ");
        for (Reporte reporte : gestorReporte1.getReportes()) {
            System.out.println("Detalles del reportes: ");
            System.out.println("Asunto " + reporte.getAsunto());
            System.out.println("Fecha " + reporte.getFecha());
        }

        nadador1.entrenar();

        //Crear reporte de evaluacion de etreanimaien
        Reporte reporteEvaluacion = new Reporte();
        reporteEvaluacion.setFecha(LocalDate.now());
        reporteEvaluacion.setAsunto("Evaluacion del rendimiento....");

        EntrenamientoAtleta tareaEntranamiento = new EntrenamientoAtleta(nadador1);

        //CREAR HILO
        Thread hiloEntrenamiento = new Thread(tareaEntranamiento);

        //Iniciar el hilo
        hiloEntrenamiento.start();
        try {
            hiloEntrenamiento.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("El hilo de entrenamiento ha sido interrumpido");
        }

        //EVALUACION ENTRENADOR
        EvaluacionEntrenamiento tareaEvaluacion = new EvaluacionEntrenamiento(nadador1, entrenador1, reporteEvaluacion, gestorReporte1);
        EvaluacionEntrenamiento tareaEvaluacion2 = new EvaluacionEntrenamiento(nadador1, entrenador2, reporteEvaluacion, gestorReporte1);

        Thread hiloEvaluacion = new Thread(tareaEvaluacion);
        Thread hiloEvaluacion2 = new Thread(tareaEvaluacion2);


        hiloEvaluacion.start();
        hiloEvaluacion2.start();


        try {
            hiloEvaluacion.join();
            hiloEvaluacion2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //INvocar el metodo de firmar el reporte
        reporteEvaluacion.firmarReporte("Reporte autorizado por Gimansio UCA");

        //Visualizar el reporte de evluacion en estrategia con estrategia con visualizacion completa
        //Establecer la estregtiga
        reporteEvaluacion.setEstrategia(estrategiaReporteCompleto);
        //Visualizar
        reporteEvaluacion.visualizar();
    }
}