import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
public class AplicacionTerminal {
    // Los métodos estáticos no pueden acceder a variables de instancia.
    public static void main(String[] args) {
        // Ponemos la letra L para que acepte el número grande.
        Contacto c1 = new Contacto("Priscila", "UASLP", 9423456789L);
        Contacto c2 = new Contacto("Pris", "SLP", 9423456781L);
        Contacto c3 = new Contacto("Priska", "MX", 9423456729L);

        Agenda agenda = new Agenda();
        agenda.agregaContacto(c1);
        agenda.agregaContacto(c2);
        agenda.agregaContacto(c3);
        agenda.imprimeTodo();
    }
}
*/

 // En caso de iniciar el nombre con una no letra y la dirección vacía, arroja la primera excepción que encuentre.
// En este caso es la excepción del del nombre.

// Otra forma.

public class AplicacionTerminal {
    private Agenda agenda;

    public AplicacionTerminal()
    {
        agenda = new Agenda();
    }

    public void demo()
    {
        // Ponemos la letra L para que acepte el número grande.
        /*Contacto c1 = new Contacto("Priscila", "UASLP", 9423456789L);
        Contacto c2 = new Contacto("Pris", "SLP", 9423456781L);
        Contacto c3 = new Contacto("Priska", "MX", 9423456729L);

        //Agenda agenda = new Agenda(); // Para usar esto las lineas de abajo van sin this.
        this.agenda.agregaContacto(c1);
        this.agenda.agregaContacto(c2);
        this.agenda.agregaContacto(c3);
        this.agenda.imprimeTodo();*/
    }

    public void entradaUsuario()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion = "";
        do
        {
            try {
                System.out.println("Opciones: agregar - cargar - eliminar - guardar - imprimir - cuenta - terminar");
                opcion = entrada.nextLine();
                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "cargar":
                        cargar(entrada);
                        break;
                    case "eliminar":
                        eliminar(entrada);
                        break;
                    // Se quiere guardar en un archivo.
                    case "guardar":
                        guardar(entrada);
                        // .csv valores separados por comas
                        // Con .csv aparece la información en Excel.
                        //agenda.guardar("archivo.csv");
                        break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                    case "cuenta":
                        contar();
                        break;
                }
            }
            // Las ponemos de acuerdo a la jerarquía de clases, las que estan más arriba van al final.
            // Busca la excepción por internet para ver el la jerarquía de clases.
            // La excepción aqui es: java.lang.StringIndexOutOfBoundsException
            catch (IllegalArgumentException ex)
            {
                System.out.println(ex.getMessage());
                opcion = "";
            }
            catch (InputMismatchException ex)
            {
                System.out.println("El telefono debe tener dígitos unicamente!");
                opcion = "";
            } catch (IOException e) {
                // Toda la llamada de la pila.
                //e.printStackTrace();
                System.out.println(e.getMessage());
                opcion = "";
            }
            catch (ExcepcionContacto ex)
            {
                System.out.println(ex.getMessage());
                opcion = "";
            }
        }while (opcion != "terminar");
    }

    private void contar()
    {
        System.out.println("Actualmente tienes " + agenda.numContactos());
    }

    private void eliminar(Scanner entrada)
    {
        System.out.print("Telefono del contacto a eliminar: ");
        long telEliminar = entrada.nextLong();
        agenda.eliminarContacto(telEliminar);
    }

    private void cargar(Scanner entrada) throws FileNotFoundException
    {
        System.out.print("Nombre del archivo: ");
        String nomArch = entrada.nextLine();
        agenda.cargar(nomArch);
    }

    private void guardar(Scanner entrada) throws IOException
    {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.guardar(nomArchivo);
    }

    private void agregar(Scanner entrada)
    {
        System.out.println("Agregar un contacto nuevo.");
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Dirección: ");
        String direccion = entrada.nextLine();
        System.out.print("Telefono: ");
        long tel = entrada.nextLong();
        Contacto nuevo = new Contacto(nombre, direccion, tel);
        agenda.agregaContacto(nuevo);
    }

    // Los métodos estáticos no pueden acceder a variables de instancia.
    public static void main(String[] args) {
        AplicacionTerminal aplicacion = new AplicacionTerminal();

        aplicacion.demo();
        aplicacion.entradaUsuario();
    }
}
