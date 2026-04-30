package org.example.ui;

import org.example.catalogo.Deporte;
import org.example.modelo.Atleta;
import org.example.modelo.Nadador;

import java.util.Scanner;

public class EntradaDatosAtleta {
    private Scanner entrada = new Scanner(System.in);

    // Metodo para solicitar datos generales del atleta
    private void entradaDatosGenerales(Atleta atleta) {

        System.out.print("Ingrese el nombre: ");
        atleta.setNombre(entrada.nextLine());
        System.out.print("Ingrese la edad: ");
        atleta.setEdad(entrada.nextInt());
        entrada.nextLine();
    }

    public Nadador entradaDatosNadador() {
        Nadador nadador = new Nadador();

        // Llamar al metodo que solicita datos generales
        entradaDatosGenerales(nadador);
        // Establecer por defecto el deporte
        nadador.setDeporte(Deporte.NATACION);

        // Solicitar datos propios del nadador
        System.out.print("Ingrese el estilo de nado: ");
        nadador.setEstilo(entrada.nextLine());
        // Devolver un objeto nadador con datos
        return nadador;
    }

}