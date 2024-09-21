import java.util.ArrayList;
import java.util.List;

public class Socio {

    private String nombre;
    private String apellido;
    private int numSocio;
    private boolean suspendido;
    private List<Prestamo> prestamosActivos;
    private int limitePrestamos = 3; //definido como constante de acuerdo a categoria de socio

    public Socio(String nombre, String apellido, int numSocio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numSocio = numSocio;
        suspendido = false;
        this.prestamosActivos = new ArrayList<>();
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

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public boolean isSuspendido() {
        return suspendido;
    }

    public void setSuspendido(boolean suspendido) {
        this.suspendido = suspendido;
    }

    public List<Prestamo> getPrestamosActivos() {
        return prestamosActivos;
    }

    public void setPrestamosActivos(List<Prestamo> prestamosActivos) {
        this.prestamosActivos = prestamosActivos;
    }

    public int getLimitePrestamos(){
        return this.limitePrestamos;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}
