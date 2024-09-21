import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Prestamo {
    private static Long numeroAutoincremental = 1l; // Static field shared by all instances to keep track of the last assigned ID
    private Long prestamoNumero;
    private Libro libro;
    private Socio socio;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaADevolver;
    private LocalDateTime fechaDevolucion;

    //se establece por defecto fecha de prestamo al momento de solicitarla, y devolucion a 7 dias. devolucion efectiva null
    public Prestamo(Libro libro, Socio socio)
    {
        this.prestamoNumero = numeroAutoincremental++; //adjudica el valor de autoIncremental, y luego le suma 1
        this.libro = libro;
        this.socio = socio;
        this.fechaPrestamo = LocalDateTime.now();
        this.fechaADevolver = LocalDateTime.now().plusDays(7);
    }

    public LocalDateTime getFechaADevolver() {
        return fechaADevolver;
    }

    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }

    public Socio getSocio() {
        return socio;
    }

    public Libro getLibro() {
        return libro;
    }

    public Long getPrestamoNumero() {
        return prestamoNumero;
    }

    //para el caso de una prórroga
    public void setFechaADevolver(LocalDateTime fechaADevolver) {
        this.fechaADevolver = fechaADevolver;
    }

    //registrar devolucion efectiva
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    //debo hacer override para comparar prestamos por prestamoNumero
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestamo prestamo = (Prestamo) o;
        return Objects.equals(prestamoNumero, prestamo.prestamoNumero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prestamoNumero);
    }
}
