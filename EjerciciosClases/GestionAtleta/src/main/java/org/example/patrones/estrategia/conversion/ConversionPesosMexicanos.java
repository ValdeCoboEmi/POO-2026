package org.example.patrones.estrategia.conversion;

public class ConversionPesosMexicanos implements EstrategiaConversionMoneda{
    private final double TIPO_CAMBIO = 20.0; // Ejemplo: 1 USD = 20 MXN

    //COnstructor
    public ConversionPesosMexicanos(){}

    @Override
    public double convertirMoneda(double monto) {
        return monto * TIPO_CAMBIO;
    }
}
