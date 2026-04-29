package org.example.patrones.estrategia.conversion;

import org.example.modelo.Pagable;

public class Planilla {
    private Pagable pagable;
    private EstrategiaConversionMoneda estrategia;

    public Planilla(){}

    public Planilla(Pagable pagable, EstrategiaConversionMoneda estrategia) {
        this.pagable = pagable;
        this.estrategia = estrategia;
    }

    public Pagable getPagable() { return pagable; }
    public void setPagable(Pagable pagable) { this.pagable = pagable; }

    public EstrategiaConversionMoneda getEstrategia() { return estrategia; }
    public void setEstrategia(EstrategiaConversionMoneda estrategia) { this.estrategia = estrategia; }

    // ================= MÉTODOS  =================

    public double calcularSalarioBase() {
        if (pagable != null) {
            return pagable.calcularSalario();
        }
        return 0.0;
    }

    public double convertirSalario() {
        if (estrategia != null && pagable != null) {
            double salarioBase = calcularSalarioBase();
            return estrategia.convertirMoneda(salarioBase);
        }
        return 0.0;
    }
}