import contador.Contador;
import contador.TareaContadorDecrementar;
import contador.TareaContadorIncremento;

public class MainContador {
    public static void main(String[] args) {

        //CREAR CONTADOR
        Contador contador = new Contador();

        //CREAR LA TAREA A PARTIR DE LA CLASE QUE IMPLEMENTA RUNNABLE
        TareaContadorIncremento tarea = new TareaContadorIncremento(contador);
        TareaContadorDecrementar tarea2 = new TareaContadorDecrementar(contador);

        //CREAR EL HILO
        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);

        Thread hilo3 = new Thread(tarea2);

        System.out.println("Estado actual del hilo 1 " + hilo1.getState());


        //Iniciar el hilo
        hilo1.start();
        hilo2.start();

        hilo3.start();

        System.out.println("Estado actual del hilo 1 " + hilo1.getState());


        try {
            System.out.println("Estado actual del hilo 2 " + hilo2.getState());
            hilo1.join();
            System.out.println("Estado actual del hilo 1 " + hilo1.getState());

            hilo2.join();
            hilo3.join();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el hilo 1: " + e.getMessage());
        }

        //IMPIRMIR EL RESULTADO
        System.out.println("Hilo principal - Valor de incremento " + contador.getContador());
    }
}
