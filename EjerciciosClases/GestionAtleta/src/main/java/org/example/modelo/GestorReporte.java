package org.example.modelo;

import org.example.patrones.estrategia.visualizacion.Reporte;

import java.util.ArrayList;
import java.util.List;

public class GestorReporte {
    private List<Reporte> reportes;

    public GestorReporte(){
        reportes = new ArrayList<>();
    }

    public GestorReporte(List<Reporte> reportes){
        this.reportes = reportes;
    }

    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reporte> reportes) {
        this.reportes = reportes;
    }

    //METODOS
    public boolean guardarReporte(Reporte reporte){
        try {
            if (reporte == null){
                System.out.println("El reporte no puede ser nulo");
                return false;
            }

            reportes.add(reporte);
            return true;
        }catch (Exception e){
            System.out.println("Error al guardar el reporte: " + e.getMessage());
            return false;
        }
    }
}
