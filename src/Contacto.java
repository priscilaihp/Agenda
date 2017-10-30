public class Contacto {
    private String nombre;
    private String direccion;
    // No cabe en un int, número grande.
    private long telefono;

    public Contacto(String nom, String dir, long tel)
    {
        if (nom.isEmpty())
        {
            throw new IllegalArgumentException("El nombre no debe estar vacío!");
        }
        // Pregunta si la primera letra es una letra.
        if (nom.charAt(0) >= 'a' && nom.charAt(0) <= 'z' || nom.charAt(0) >= 'A' && nom.charAt(0) <= 'Z')
        {
            this.nombre = nom;
        } else
        {
            // Creamos nuestra excepcion. Lanza una excepcion.
            // new IllegalArgumentException(); <- Es un objeto.
            RuntimeException ex = new IllegalArgumentException("El nombre debe iniciar con una letra!");
            throw ex;
        }

        // Quita los espacios. Por que el trim regresa una copia pero sin espacios y tienes que guardar esa nueva copia de la cadena.
        dir = dir.trim();
        // Pregunta si esta vacio.
        if (dir.isEmpty())
        {
            throw new IllegalArgumentException("La dirección no debe estar vacía!");
        }
        else
        {
            this.direccion = dir;
        }
        // No se puede hacer cast de primitivo a objetos.
        // String cadTel = (String)tel;
        String cadTel = Long.toString(tel);
        if (cadTel.length() == 10)
        {
            this.telefono = tel;
        }
        else
        {
            throw new IllegalArgumentException("El telefono debe tener 10 digitos!");
        }
    }

    // Para que nos mande la información y no la dirección.
    @Override
    public String toString()
    {
        return nombre + ", " + direccion + ", " + telefono;
    }
}
