package org.example.patrones.estrategia.conversion;

public class ConversionEuros implements EstrategiaConversionMoneda{
    private final double tipoCambio = 0.85; // Ejemplo: 1 USD = 0.85 EUR

    //Constructor
    public ConversionEuros(){}

    @Override
    public double convertirMoneda(double moneda) {
        return moneda * tipoCambio;
    }
}
