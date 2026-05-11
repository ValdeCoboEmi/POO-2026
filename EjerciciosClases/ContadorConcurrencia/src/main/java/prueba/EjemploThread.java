package prueba;

public class EjemploThread extends Thread {

    //Constructor
    public void EjemploThread() {
    }

    @Override
    public void run() {
        try {
            //Estado cambia a time waiting
            Thread.sleep(2000);
            // el impirmir en pantalla --estado temporal
            System.out.println("Thread ejecuntandose");
        } catch (InterruptedException e) {
            System.out.println("Thread interrumpido: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
