import java.time.LocalDateTime;
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
    //TODO
    public Libro encontrarLibroPorISBN(int isbn)
    {
        return new Libro();
    }
    //TODO
    public List<Libro> encontrarLibroPorAutores(String autores)
    {
        return new ArrayList<Libro>();
    }
    //TODO
    public List<Libro> encontrarLibroPorTitulo(String titulo)
    {
        return new ArrayList<Libro>();
    }

    public boolean chequearDisponible(Libro libro)
    {
        return libro.getEjemplaresDisponibles() > 0;
    }
    public void prestarLibro(Libro libro, Socio socio)
    {
        //chequea ejemplares disponibles
        if (!chequearDisponible(libro))
        {
            System.out.println("No hay ejemplares disponibles de ese título :(");
            return;
        }
        //verifica que el socio esté al día
        if(socio.isSuspendido())
        {
            System.out.println("El socio " + socio + " debe regularizar su situación antes de poder recibir préstamos");
            return;
        }
        //verifica que el socio no haya alcanzado un límite de préstamos
        if(socio.getPrestamosActivos().size() >= socio.getLimitePrestamos())
        {
            System.out.println("El socio " + socio + " ya alcanzó su límite de "
                    + socio.getLimitePrestamos() + " préstamos simultáneos");
        }
        //si hay disponibles y el socio está activo, crea un prestamo
        Prestamo prestamo = new Prestamo(libro, socio);
        //sustrae un ejemplar de los disponibles
        libro.setEjemplaresDisponibles(libro.getEjemplaresDisponibles()-1);
        //si retira el último disponible, avisa
        if(libro.getEjemplaresDisponibles()==0)
        {
            System.out.println("Está retirando el último ejemplar disponible de " + libro);
        }
        //adjudica el préstamo al socio
        socio.getPrestamosActivos().add(prestamo);
        //informa prestamo
        System.out.println("El título con ISBN " + libro.getIsbn() + " deberá ser devuelto el día " +
                prestamo.getFechaADevolver());
    }

    public void devolverLibro(Prestamo prestamo)
    {
        //establece fecha de devolucion prestamo
        prestamo.setFechaDevolucion(LocalDateTime.now());
        //si la fecha de devolucion es posterior a la esperada..., suspende al socio!
        if(prestamo.getFechaDevolucion().isAfter(prestamo.getFechaADevolver())) //metodo nativo "isAfter()"
        {
            System.out.println("La fecha de devolución venció el " + prestamo.getFechaADevolver());
            System.out.println("Se procede a suspender al socio " + prestamo.getSocio());
            prestamo.getSocio().setSuspendido(true);
        }
        //agrega un ejemplar a disponibles
        prestamo.getLibro().setEjemplaresDisponibles(prestamo.getLibro().getEjemplaresDisponibles()+1);
        //elimina el prestamo de la lista de prestamos activos del socio
        prestamo.getSocio().getPrestamosActivos().removeIf(p -> p.getPrestamoNumero().equals(prestamo.getPrestamoNumero()));
        //explicacion de la expresion lambda y programacion funcional

        /*

        Explanation:
        removeIf(): This is a method available for Java Collections (like List). It removes all elements from the list that satisfy the given condition (predicate). In this case, it removes a Prestamo from the list if its prestamoId matches the one provided.

        p -> p.getPrestamoId().equals(prestamo.getPrestamoId()):

        This is a lambda expression. It's shorthand for defining a function.
        p represents each element in the list (in this case, a Prestamo object).
        The lambda checks whether the prestamoId of p (each Prestamo in the list) is equal to the prestamoId of the prestamo you're trying to remove.
        This is essentially a functional predicate being passed to removeIf(). It means "remove any element p from the list where the condition p.getPrestamoId().equals(prestamo.getPrestamoId()) holds true."

        Is this a stream?
        No, this is not directly using a stream. It is using a functional interface (Predicate) with the removeIf() method. The Stream API allows for more complex operations like filtering, mapping, and reducing, but this particular operation is simply a method call on the list with a lambda.

        Can it be "unboxed"?
        Yes, it can be "unboxed" into a more traditional for loop if you want to make the logic more explicit and easier to read for people unfamiliar with lambdas.

        Here’s how you could break it down:

        List<Prestamo> prestamosActivos = prestamo.getSocio().getPrestamosActivos();
        Prestamo toRemove = null;

        for (Prestamo p : prestamosActivos) {
            if (p.getPrestamoId().equals(prestamo.getPrestamoId())) {
                toRemove = p;  // Store the item to remove
                break;         // Exit the loop once found
            }
        }

        if (toRemove != null) {
            prestamosActivos.remove(toRemove);  // Remove the prestamo
        }

        Explanation of the "unboxed" version:
        You iterate over the list of Prestamo objects in a traditional for loop.
        When you find the Prestamo that matches the prestamoId, you store it in a variable (toRemove).
        After the loop, you remove the Prestamo from the list.
        This way, you achieve the same result but with more explicit code and without using a lambda or removeIf().

         */

    }
}
