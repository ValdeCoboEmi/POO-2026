import contador.Contador;
import contador.HiloContador;

public class MainContador {
    public static void main(String[] args) {

        //CREAR CONTADOR
        Contador contador = new Contador();

        //CREAR LA TAREA A PARTIR DE LA CLASE QUE IMPLEMENTA RUNNABLE
        HiloContador tarea = new HiloContador(contador);

        //CREAR EL HILO
        Thread hilo = new Thread(tarea);

        //Iniciar el hilo
        hilo.start();

        try {
            hilo.join();
        }catch(Exception e){}

        //IMPIRMIR EL RESULTADO
        System.out.println("Valor de incremento " + contador.getContador());
    }
}
