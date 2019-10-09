import Util.Lib;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Lib lib= new Lib();
    private static Scanner lector= new Scanner(System.in);
    private static ArrayList<Personaje> jugadores= new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("jugadores.dat");
        FileReader fr= new FileReader(fichero);
        FileInputStream fis;
        ObjectInputStream ois;

        boolean existe;
        int i;
        int opcion;

        if (fr.read()>0){
            fis= new FileInputStream(fichero);
            ois= new ObjectInputStream(fis);
            jugadores= (ArrayList<Personaje>) ois.readObject();
            ois.close();
        }

        do {
            System.out.println("**************************");
            i= jugadores.size();
            if (i==0){
                System.out.println("No se ha cargado ningún jugador.");
                existe=false;
            }else {
                System.out.println("Se han cargado " + i + " jugadores.");
                existe=true;
            }
            opcion = menuPrincipal();
            switch (opcion) {
                case 1:
                    if (existe){
                        System.out.println(jugadores);

                    }else{
                        System.out.println("No hay jugadores para mostrar.");

                    }
                    break;
                case 2:
                    agregarJugadores();
                    break;
                case 3:
                    if (existe){
                        eliminarJugadores();
                    }else{
                        System.out.println("No hay jugadores para eliminar.");

                    }
                    break;
                case 4:
                    if (existe){
                        modificarJugadores();
                    }else{
                        System.out.println("No hay jugadores para modificar.");

                    }
                    break;
                case 0:
                    salir(jugadores, fichero);
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        } while (opcion != 0);

    }
    public static int menuPrincipal(){
        int opcion;
        System.out.println("---------------");
        System.out.println("MENU PRINCIPAL");
        System.out.println("---------------");
        System.out.println("1. Listar Jugadores.");
        System.out.println("2. Agregar Jugador.");
        System.out.println("3. Eliminar Jugador.");
        System.out.println("4. Modificar Jugador.");
        System.out.println("0. Salir.");
        opcion=lib.validarOpcion(0,4);
        return opcion;
    }
    public static void agregarJugadores() throws IOException {
        String nombre;
        String tipo;
        boolean agregado;
        boolean existe=false;

        do {
            System.out.println("Dime el nombre del personaje: ");
            nombre= lector.nextLine();

            System.out.println("Dime el tipo de personaje:");
            tipo= lector.nextLine();
            Personaje p= new Personaje(nombre,tipo);
            for (Personaje pe: jugadores) {
                if (pe.equals(p)){
                    System.out.println("El jugador ya existe, elija otro.");
                    existe=true;
                }
            }

            if (!existe && jugadores.add(p)){
                System.out.println("Jugador agregado con éxito.");
                agregado=true;
            }else{
                System.out.println("El jugador no ha podido ser agregado. Intenta de nuevo.");
                agregado= false;
            }

        }while (!agregado);

    }
    public static void modificarJugadores(){
        String nombre;
        String nombreNuevo=" ";
        String tipoNuevo=" ";
        int id;
        boolean modificado;
        int opcion;
        System.out.println("Dime el nombre del jugador a modificar:");
        nombre= lector.nextLine();
        for( Personaje p : jugadores) {
            if (p.getNombre().equalsIgnoreCase(nombre)){
                System.out.println("ID:"+jugadores.indexOf(p)+", "+p.toString());
            }
        }
        do {
            System.out.println("Indica el id del personaje que deseas modificar:");
            id= lector.nextInt();
            lector.nextLine();
            System.out.println("Dime el campo a modificar del personaje:");
            System.out.println("1.Nombre.");
            System.out.println("2.Tipo.");
            System.out.println("****************");
            opcion=lib.validarOpcion(1,2);

            switch (opcion){
                case 1:
                    System.out.println("Dime el nuevo nombre:");
                    nombreNuevo=lector.nextLine();
                    jugadores.get(id).setNombre(nombreNuevo);

                    break;
                case 2:
                    System.out.println("Dime el nuevo tipo:");
                    tipoNuevo=lector.nextLine();
                    jugadores.get(id).setTipo(tipoNuevo);
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }

            if (jugadores.get(id).getNombre().equalsIgnoreCase(nombreNuevo) || jugadores.get(id).getTipo().equalsIgnoreCase(tipoNuevo) ){
                System.out.println("Personaje modificado con éxito.");
                modificado=true;
            }else {
                System.out.println("El personaje no ha podido ser modificado. Intenta de nuevo");
                modificado=false;
            }
        }while(!modificado);


    }
    public static void eliminarJugadores(){
        String nombre;
        int id;
        boolean eliminado;
        do {
            System.out.println("Dime el nombre del jugador a eliminar:");
            nombre= lector.nextLine();
            for( Personaje p : jugadores) {
                if (p.getNombre().equals(nombre)){
                    System.out.println(jugadores.indexOf(p)+": "+p.toString());
                }
            }
            System.out.println("Indica el id del personaje que deseas eliminar:");
            id= lector.nextInt();
            lector.nextLine();

            if (jugadores.remove(jugadores.get(id))){
                System.out.println("Personaje eliminado con éxito.");
                eliminado=true;
            }else {
                System.out.println("El personaje no ha podido ser eliminado.");
                eliminado=false;
            }

        }while(!eliminado);


    }
    public static void salir(ArrayList<Personaje> jugadores, File fichero) throws IOException {
        File fich;
        FileOutputStream fos;
        ObjectOutputStream oos;

        if (fichero.delete()){
            fich= new File("jugadores.dat");
            fos= new FileOutputStream(fich);
            oos= new ObjectOutputStream(fos);
            oos.writeObject(jugadores);
            oos.close();
        }

    }
}
