package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Entrenador implements Pagable, Imprimible {

    String nombre;
    // años de experiencia
    int experiencia;
    double salario;
    // Colección lista
    List <Atleta> atletasAsignados;

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
    // no es necesario el set
    public void setAtletasAsignados(List<Atleta> atletasAsignados) {
        this.atletasAsignados = atletasAsignados;
    }

    @Override
    public double calcularSalario(){
        // Si años de experiencia es mayor a 3 incrementar el 5%
        final double SALARIO_BASE = 2000;

        if (experiencia >= 3){
            salario = SALARIO_BASE + (SALARIO_BASE * 0.05);
        }else {
            salario = SALARIO_BASE;
        }

        return salario;
    }

    @Override
    public void imprimir() {
        System.out.println("Entrenador: " + nombre);
        System.out.println("\nAtletas asignados:");
        for (Atleta a : atletasAsignados) {
            System.out.println("- " + a.getNombre());
        }
    }

    // Metodos
    public boolean agregarAtleta(Atleta atleta) {
        return this.atletasAsignados.add(atleta);
    }

    // determinar Objetivo Plan de Entrenamiento

    // preescribir Plan de entrenamiento



}
