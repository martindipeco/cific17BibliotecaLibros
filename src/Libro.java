public class Libro {

    private String titulo;
    private String autores;
    private int isbn;
    private String ubicacion;
    private int ejemplaresTotales;
    private int ejemplaresDisponibles;

    public Libro(){}

    //constructor con 1 ejemplar por defecto
    public Libro(String titulo, String autores, int isbn, String ubicacion)
    {
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.ubicacion = ubicacion;
        ejemplaresTotales = 1;
        ejemplaresDisponibles = 1;
    }

    //al momento de creacion, ejemplares disponibles = totales
    public Libro(String titulo, String autores, int isbn, String ubicacion, int ejemplaresTotales)
    {
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.ubicacion = ubicacion;
        this.ejemplaresTotales = ejemplaresTotales;
        ejemplaresDisponibles = ejemplaresTotales;
    }

    //constructor completo, acaso haya alguna restriccion de disponibilidad
    public Libro(String titulo, String autores, int isbn, String ubicacion, int ejemplaresTotales, int ejemplaresDisponibles)
    {
        this.titulo = titulo;
        this.autores = autores;
        this.isbn = isbn;
        this.ubicacion = ubicacion;
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutores() {
        return autores;
    }

    public void setAutores(String autores) {
        this.autores = autores;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public void setEjemplaresTotales(int ejemplaresTotales) {
        this.ejemplaresTotales = ejemplaresTotales;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    @Override
    public String toString() {
        return titulo + ", de " + autores;
    }
}
