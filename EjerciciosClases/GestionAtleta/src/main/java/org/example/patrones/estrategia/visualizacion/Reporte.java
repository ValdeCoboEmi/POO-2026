package org.example.patrones.estrategia.visualizacion;

import java.time.LocalDate;

public class Reporte {
    private String asunto;
    private LocalDate fecha;
    private EstrategiaVisualizacion estrategia;

    //CONSTRUCTORES
    public Reporte() {
    }

    public Reporte(String asunto, LocalDate fecha,  EstrategiaVisualizacion estrategia) {
        this.asunto = asunto;
        this.fecha = fecha;
        this.estrategia = estrategia;
    }

    /// GETTER SETTER
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public EstrategiaVisualizacion getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaVisualizacion estrategia) {
        this.estrategia = estrategia;
    }

    //METODOS
    public void visualizar() {
        if (estrategia != null) {
            estrategia.visualizar(this);
        } else {
            System.out.println("No se ha definido una estrategia de visualización para este reporte.");
        }

    }
}
