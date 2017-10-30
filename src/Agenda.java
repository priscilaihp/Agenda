import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

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
}
