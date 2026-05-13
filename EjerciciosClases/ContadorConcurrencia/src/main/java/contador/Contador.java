package contador;

public class Contador {
    //ATRIBUTOS
    private int contador = 0;
    //Lock de sincronizacion
    private final Object lock = new Object();

    //CONSTRUCTOR
    public Contador(){}

    public Contador(int contador) {
        this.contador = contador;
    }

    //GETTER AND SETTER
    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //public synchronized void incrementar(){
    //    contador++;
    //}

    public void incrementar(){
        synchronized (lock) {
            contador++;
        }
    }

    public void decrementar(){
        synchronized (lock) {
            contador = contador - 10;
            //Contador =- 10;
        }
    }
}
