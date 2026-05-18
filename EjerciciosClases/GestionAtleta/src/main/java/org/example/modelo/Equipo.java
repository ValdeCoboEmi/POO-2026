package org.example.modelo;

import java.util.ArrayList;
import java.util.List;

public class Equipo implements Imprimible{

    // atributos
    private String nombre;
    private List<Atleta> miembrosEquipo;

    // constructores
    public Equipo() {
        miembrosEquipo = new ArrayList<Atleta>();
    }

    public Equipo(String nombre, List<Atleta> miembrosEquipo) {
        this.nombre = nombre;
        this.miembrosEquipo = miembrosEquipo;
    }

    // Getter / setter
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Atleta> getMiembrosEquipo() {
        return miembrosEquipo;
    }
    public void setMiembrosEquipo(List<Atleta> miembrosEquipo) {
        this.miembrosEquipo = miembrosEquipo;
    }

    // metodos
    public boolean agregarMiembroEquipo(Atleta atleta) {
        if (atleta == null) {
            return false;
        }
        return miembrosEquipo.add(atleta);
    }

    @Override
    public void imprimir() {
        System.out.println("\nNombre del equipo: " + nombre);
        System.out.println("Miembros equipo ");
        for (Atleta atleta : miembrosEquipo) {
            System.out.println(" -Nombre del atleta: "+ atleta.getNombre());
        }
    }

}