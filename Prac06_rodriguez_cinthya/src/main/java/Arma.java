import java.io.Serializable;

public class Arma implements Serializable {
    private static final long serialVersionUID= 1L;
    private String nombre;
    private int vida;

    public Arma(String nombre) {
        this.nombre = nombre;
        this.vida = 100;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    @Override
    public String toString() {
        return nombre +": "+ vida+"\n";
    }
}
