package com.cinthyasophia.JuegoRolesADA;

import java.io.*;

public class Juego implements Serializable {
    private final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Personaje ogro = new Personaje("Ogro verde","Orc");
        Personaje elfo = new Personaje("Elfo de la melena","Elf");
        Personaje mag = new Personaje("Harry el mago","Mag");

        System.out.println(ogro.toString());
        System.out.println(elfo.toString());
        System.out.println(mag.toString());

        File fichero = new File("juego.dat");

        FileOutputStream fos = new FileOutputStream( fichero);
        ObjectOutputStream oos= new ObjectOutputStream(fos);

        oos.writeObject(ogro);
        oos.writeObject(elfo);
        oos.writeObject(mag);

        oos.close();

        //DEs
        FileInputStream fis = new FileInputStream( fichero);
        ObjectInputStream ois= new ObjectInputStream(fis);

        Personaje per1= (Personaje) ois.readObject();
        Personaje per2= (Personaje) ois.readObject();
        Personaje per3= (Personaje) ois.readObject();


        ois.close();
        
    }
}
