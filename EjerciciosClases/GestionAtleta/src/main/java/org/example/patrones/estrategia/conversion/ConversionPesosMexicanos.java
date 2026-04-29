package org.example.patrones.estrategia.conversion;

public class ConversionPesosMexicanos implements EstrategiaConversionMoneda{
    private final double tipoCambio = 20.0; // Ejemplo: 1 USD = 20 MXN

    //COnstructor
    public ConversionPesosMexicanos(){}

    @Override
    public double convertirMoneda(double moneda) {
        return moneda * tipoCambio;
    }
}
