package contador;

public class Contador {
    //ATRIBUTOS
    private int contador = 0;

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

    public void incrementar(){
        contador++;
    }
}
