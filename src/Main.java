public class Main {
    public static void main(String[] args) {

        System.out.println("Bienvenidos al servicio de biblioteca");

        //crear un bibliotecario
        Bibliotecario bibliotecario = new Bibliotecario();

        //crear una biblioteca
        Biblioteca biblioteca = new Biblioteca("Calle Principal 1", bibliotecario);

        //crear libros
        Libro libro1 = new Libro("Don Quijote", "Miguel de Cervantes", 1234, "Pasillo 4, estante 2");

        //crear socios
        Socio socio1 = new Socio("Juana", "Azurduy", 1);

        //crear prestamo
        bibliotecario.prestarLibro(libro1, socio1);

    }
}