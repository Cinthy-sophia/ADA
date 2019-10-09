import java.io.Serializable;
import java.util.ArrayList;

public class Personaje implements Serializable {

    private static final long serialVersionUID= 1L;

    private String nombre;
    private String tipo;
    private int fuerza;
    private int vida;
    private ArrayList<Arma> armas;
    private ArrayList<Item> mochila;

    public Personaje(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fuerza = calcularFuerza(tipo);
        this.vida = 100;
        this.armas = new ArrayList<>();
        this.mochila= new ArrayList<>();
        setArmas(armaPorDefecto(tipo));

    }

    public ArrayList<Item> getMochila() {
        return mochila;
    }

    public void setMochila(ArrayList<Item> mochila) {
        this.mochila = mochila;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ArrayList<Arma> getArmas() {
        return armas;
    }

    public void setArmas(Arma arma) {
        this.armas.add(arma);
    }

    public int calcularFuerza(String tipo){
        int fuerza= 0;
        switch (tipo){
            case "Orc":
                fuerza=70;
            break;
            case "Elf":
                fuerza=40;
            break;
            case "Mag":
                fuerza=30;
            break;
            default:
                fuerza= 50;
            break;

        }
        return fuerza;
    }

    public Arma armaPorDefecto(String tipo){
        Arma arma;
        switch (tipo){
            case "Orc":
                arma=new Arma("Hacha del Leñador");
            break;
            case "Elf":
                arma=new Arma("Arco de Fusta ");
                break;
            case "Mag":
                arma=new Arma("Varita de Pluma de Fenix ");
                break;
            default:
                arma=new Arma("Manos");
                break;

        }
        return arma;
    }

    @Override
    public String toString() {
        return  "\t|"+nombre +"\t|\n" +
                "\t|Tipo: " + tipo + "\t|\n " +
                "\t|Fuerza: " + fuerza +"\t|\n"+
                "\t|Vida: " + vida + "\t|\n" +
                "\tArmas: " + armas + "\n"+
                "\tMochila: " + mochila+"\n";
    }
}
