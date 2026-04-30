package org.example.patrones.estrategia.conversion;

public class ConversionEuros implements EstrategiaConversionMoneda{
    private final double TIPO_CAMBIO = 0.85; // Ejemplo: 1 USD = 0.85 EUR

    //Constructor
    public ConversionEuros(){}

    @Override
    public double convertirMoneda(double monto) {
        return monto * TIPO_CAMBIO;
    }
}
