import java.util.ArrayList;
import java.util.List;

//equivalente a una clase de Servicio de Libro
public class Bibliotecario {

    public String nombre;
    public String apellido;
    public int legajo;
    public boolean deVacaciones;

    public Bibliotecario(){}

    public Bibliotecario(String nombre, String apellido, int legajo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        deVacaciones = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public boolean isDeVacaciones() {
        return deVacaciones;
    }

    public void setDeVacaciones(boolean deVacaciones) {
        this.deVacaciones = deVacaciones;
    }

    //Métodos de servicio

    public Libro encontrarLibroPorISBN(int isbn)
    {
        return new Libro();
    }

    public List<Libro> encontrarLibroPorAutores(String autores)
    {
        return new ArrayList<Libro>();
    }

    public List<Libro> encontrarLibroPorTitulo(String titulo)
    {
        return new ArrayList<Libro>();
    }

    public boolean chequearDisponible(Libro libro)
    {
        return libro.getEjemplaresDisponibles() > 0;
    }
    public void prestarLibro(Libro libro)
    {
        //llama al metodo chequear disponible
        if (!chequearDisponible(libro))
        {
            System.out.println("No hay ejemplares disponibles de ese título :(");
            return;
        }
        //si hay disponibles, crea un prestamo
        System.out.println("Procediendo a crear un prestamo de " + libro.toString());

        //sustrae un ejemplar de los disponibles
        //adjudica un ejemplar a un socio
        //establece fecha de devolucion (A CONFIRMAR)
    }

    public void devolverLibro(Libro libro)
    {
        //agrega un ejemplar a disponibles
        //establece prestamo como finalizado ok o con demora (A CONFIRMAR)
    }
}
