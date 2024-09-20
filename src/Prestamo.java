import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class Prestamo {

    private List<Libro> librosEnPrestamo;

    private Socio socio;

    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaADevolver;
    private LocalDateTime fechaDevolucion;

    //se establece por defecto fecha de prestamo al momento de solicitarla, y devolucion a 7 dias. devolucion efectiva null
    public Prestamo(List<Libro> librosEnPrestamo, Socio socio)
    {
        this.librosEnPrestamo = librosEnPrestamo;
        this.socio = socio;
        this.fechaPrestamo = LocalDateTime.now();
        this.fechaADevolver = LocalDateTime.now().plusDays(7);
    }

    //para el caso de una prórroga
    public void setFechaADevolver(LocalDateTime fechaADevolver) {
        this.fechaADevolver = fechaADevolver;
    }

    //registrar devolucion efectiva

    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
