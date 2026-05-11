import prueba.EjemploRunnable;
import prueba.EjemploThread;

public class Main {
    public static void main(String[] args) {
        try {

            //Crear el hilo
            EjemploThread hilo1 = new EjemploThread();

            //Crear el objeot de la clase Ejmplo runnable
            EjemploRunnable tareaRunnable = new EjemploRunnable();

            //Crear el hilo que ejecutara a la tareaRunnable
            //Ocupando la clase Padre Thread, ya que sus hijas son los thread nuestros y runnable
            Thread hilo2 = new Thread(tareaRunnable);

            //Iniciar el hilo - estado runnable
            hilo1.start();
            hilo2.start();
            hilo1.join();
            hilo2.join();

            System.out.println("Hilo principaal ejecutandose");
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
