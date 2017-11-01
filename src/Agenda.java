import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Agenda {
    // Lista para Contactos.
    private LinkedList<Contacto> contactos;

    public Agenda()
    {
        contactos = new LinkedList<Contacto>();
    }

    public void agregaContacto(Contacto nuevo)
    {
        contactos.add(nuevo);
    }

    public void imprimeTodo()
    {
        // for-tradicional
        /*for (int i = 0; i < contactos.size(); i++)
        {
            System.out.println(contactos.get(i));
        }*/
        // for-each
            // Sintaxis
            /* for (Tipo var : coleccion)
            * {
            *       acciones con la variable var
            * }*/
        for (Contacto c : contactos)
        {
            System.out.println(c);
        }
    }

    // Crea un archivo y guarda la información del contacto.
    public void guardar(String s) throws IOException
    {
        FileWriter archivo = new FileWriter(s);
        for (Contacto c : contactos)
        {
            // Agregamos salto de línea en cada contacto.
            archivo.write(c.toString() + "\n");
            //archivo.write("\n");
        }
        archivo.close();
    }

    public void cargar(String nomArch) throws FileNotFoundException
    {
        Scanner archivo = new Scanner(new File(nomArch));
        while (archivo.hasNextLine())
        {
            String linea = archivo.nextLine();
            //System.out.println("Contenido: " + linea);
            //Contacto nuevo = new Contacto();
            String [] arreglo = linea.split(",");
            System.out.println("Nom: " +arreglo[0]);
            System.out.println("Dir: " +arreglo[1]);
            System.out.println("Tel: " +arreglo[2]);
            long tel = Long.parseLong(arreglo[2].trim());
            Contacto nuevo = new Contacto(arreglo[0], arreglo[1], tel);
            contactos .add(nuevo);
        }
    }

    public void eliminarContacto(long telEliminar)
    {
        // No se recomienda usar el for each para eliminar.
        /*
        for (Contacto c: contactos)
        {
            if (telEliminar == c.dimeTel())
            {
                // Pasamos el objeto.
                contactos.remove(c);
                // Esto es para que al eliminar el primer elemento no comtinue el ciclo, de no hacer esto te manda una excepcion debido a que pierde el ciclo.
                break;
            }
        }
        */

        // Un iterador es un objeto que permite acceder a los elementos de una colección uno por uno.

        // Un iterador se declara del tipo de dato (objeto) que contiene la colección.
        Iterator<Contacto> it;

        // El iterador se inicializa por medio del método iterator() de la colección.
        it = contactos.iterator();

        //El iterador tiene tres métodos:
        // 1. next() - regresa el siguiente elemento de la colección.
        // 2. hasNext() - verifica si todavía hay elementos en la colección.
        // 3. remove() - elimina el elemento actual de la colección.
        while (it.hasNext())
        {
            Contacto c = it.next();
            if (telEliminar == c.dimeTel())
            {
                it.remove();
            }
        }
    }
}
