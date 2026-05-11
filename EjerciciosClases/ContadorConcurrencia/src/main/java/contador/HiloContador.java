package contador;

public class HiloContador implements Runnable {
    private Contador contador;

    //CONSTRUCTOR
    public HiloContador(Contador contador) {
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

            for (int i = 1; i <= 5; i++) {
                contador.incrementar();
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            System.out.println("Error en el hilo: " + e.getMessage());
        }
    }
}
