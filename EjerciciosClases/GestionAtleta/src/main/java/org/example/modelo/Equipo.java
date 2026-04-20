package org.example.modelo;


import java.util.ArrayList;
import java.util.List;

public class Equipo implements Imprimible {

    // atributos
    private String nombreEquipo;
    private List<Atleta> miembrosEquipo;

    // constructores
    public Equipo() {
        this.miembrosEquipo = new ArrayList<>();
    }

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.miembrosEquipo = new ArrayList<>();
    }

    // GETTER Y SETTER
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public List<Atleta> getMiembrosEquipo() {
        return miembrosEquipo;
    }

    //METODOS
    public boolean agregarMiembro(Atleta atleta) {
        try {
            if (atleta == null) {
                throw new IllegalArgumentException("El atleta no puede ser nulo.");
            } else if (miembrosEquipo.contains(atleta)) {
                throw new IllegalArgumentException("El atleta ya es miembro del equipo.");

            }
            else if(miembrosEquipo == null){
                miembrosEquipo = new ArrayList<>();
            }

            miembrosEquipo.add(atleta);
            return true;
        }catch(Exception e) {
            System.out.println("Error al agregar miembro al equipo: " + e.getMessage());
            return false;
        }
    }

    // Imprimir
    @Override
    public void imprimir() {
        // agregar informacion
        System.out.println("\n\nNombre del equipo: " + this.nombreEquipo);

        System.out.println("\nMiembros del equipo: ");
        for (Atleta atleta : miembrosEquipo) {
            System.out.println("Nombre del atleta: " + atleta.getNombre());
            System.out.println("Edad del atleta: " + atleta.getEdad());
        }
    }

}
