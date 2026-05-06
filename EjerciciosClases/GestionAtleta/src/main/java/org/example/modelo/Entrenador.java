package org.example.modelo;

import org.example.patrones.estrategia.visualizacion.Reporte;

import java.util.ArrayList;
import java.util.List;

public class Entrenador implements Pagable, Imprimible {

    String nombre;
    // años de experiencia
    int experiencia;
    double salario;
    // Colección lista
    List<Atleta> atletasAsignados;

    public Entrenador() {
        this.atletasAsignados = new ArrayList<>();
    }

    public Entrenador(String nombre, int experiencia) {
        this.nombre = nombre;
        this.experiencia = experiencia;
        this.salario = 0.0;
        this.atletasAsignados = new ArrayList<>();
    }

    public double getSalario() {
        return salario;
    }

    // No es necesario el set
    public void setSalario(double salario) {
        this.salario = salario;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public List<Atleta> getAtletasAsignados() {
        return atletasAsignados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // no es necesario el set
    public void setAtletasAsignados(List<Atleta> atletasAsignados) {
        this.atletasAsignados = atletasAsignados;
    }

    @Override
    public double calcularSalario() {
        // Si años de experiencia es mayor a 3 incrementar el 5%
        final double SALARIO_BASE = 2000;

        if (salario == 0){
            salario = SALARIO_BASE;
        }

        if (experiencia >= 3) {
            salario = salario + (salario * 0.05);
        }

        return salario;
    }

    @Override
    public void imprimir() {
        System.out.println("Entrenador: " + nombre);
        System.out.println("\nAtletas asignados:");
        if (atletasAsignados.isEmpty()) {
            System.out.println("No hay atletas asignados.");
        } else {
            for (Atleta a : atletasAsignados) {
                System.out.println("- " + a.getNombre());
            }
        }
    }

    // Metodos
    public boolean agregarAtleta(Atleta atleta) {
        return this.atletasAsignados.add(atleta);

    }

    // determinar Objetivo Plan de Entrenamiento
    public String determinarObjetivoPlanEntrenamiento(Atleta atleta) {
        String objetivo = "";

        objetivo = switch (atleta.getClasificacionIMC()) {
            case "Bajo peso" -> "Ganar masa muscular";
            case "Peso normal" -> "Mantenimiento";
            case "Sobrepeso" -> "Gasto Caloricos";
            case "Obesidad" -> "Acondicionamieno metabolico";
            default -> "Valor de IMC no válido";
        };

        return objetivo;
    }

    // preescribir Plan de entrenamiento
    public boolean preescribirPlanEntrenamiento(Atleta atleta, PlanEntrenamiento plan) {
        if (atleta == null || plan == null) {
            System.out.println("Atleta o plan de entrenamiento no pueden ser nulos.");
            return false;
        }

        atleta.recibirPLanEntrenamiento(plan);
        return true;
    }

    //ENVIAR REPORTE
    public boolean enviarReporte(GestorReporte gestor, Reporte reporte){
        if (gestor == null || reporte == null) {
            System.out.println("Gestor de reportes o reporte no pueden ser nulos.");
            return false;
        }
        else {
            gestor.guardarReporte(reporte);
            return true;
        }
    }
}
