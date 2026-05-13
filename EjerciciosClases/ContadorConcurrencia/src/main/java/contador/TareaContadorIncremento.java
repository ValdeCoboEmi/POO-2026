package contador;

public class TareaContadorIncremento implements Runnable {
    private Contador contador;

    //CONSTRUCTOR
    public TareaContadorIncremento(Contador contador) {
        this.contador = contador;
    }

    //GETTER SETTER
    public Contador getContador() {
        return contador;
    }

    public void setContador(Contador contador) {
        this.contador = contador;
    }

    @Override
    public void run() {
        try {

            for (int i = 1; i <= 1000; i++) {
                contador.incrementar();
                //Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.out.println("Error en el hilo: " + e.getMessage());
        }
        //System.out.println("Hilo " + Thread.currentThread().getName() + " - Valor de incremento: " + contador.getContador());
    }
}
