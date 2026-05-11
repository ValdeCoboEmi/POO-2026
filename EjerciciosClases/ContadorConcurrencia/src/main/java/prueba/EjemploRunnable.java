package prueba;

public class EjemploRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("Ejecutando el método run() en un hilo separado");
    }
}
