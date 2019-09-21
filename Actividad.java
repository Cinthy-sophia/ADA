import java.io.*;
public class Actividad {
    public static void main(String[] args) {
        try{ 
            PrintWriter fichero = new PrintWriter (new FileWriter("FichTexto1.txt"));
            for (int i=1; i<11; i++){
                fichero.println("Fila numero: "+i); //escribe una línea
            }
        }catch (FileNotFoundException fn ){                 
            System.out.println("No se encuentra el fichero");
        }catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
