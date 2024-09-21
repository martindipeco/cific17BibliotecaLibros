import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private String direccion;
    private Bibliotecario bibliotecario;
    private List<Libro> listaLibros;

    public Biblioteca(String direccion, Bibliotecario bibliotecario) {
        this.direccion = direccion;
        this.bibliotecario = bibliotecario;
        this.listaLibros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro)
    {
        listaLibros.add(libro);
    }

    public Libro encontrarLibroPorISBN(int isbn)
    {
        for(Libro l : listaLibros)
        {
            if(l.getIsbn() == isbn)
            {
                return l;
            }
        }
        System.out.println("No se encontró ningún libro con ISBN " + isbn);
        return null;
    }

    //devuelve lista de autores que coincidan con al menos 3 letras
    public List<Libro> encontrarLibroPorAutores(String autores)
    {
        List<Libro> librosEncontrados = new ArrayList<>();
        if(autores.length() > 2)
        {
            for (Libro l: listaLibros)
            {
                if(l.getAutores().toLowerCase().contains(autores.toLowerCase()))
                {
                    librosEncontrados.add(l);
                }
            }
        }
        else
        {
            System.out.println("Por favor ingrese al menos 3 caracteres");
            System.out.println("Se devuelve una lista vacía");
        }
        return librosEncontrados;
    }

    //devuelve lista de titulos que coincidan con al menos 5 letras
    public List<Libro> encontrarLibroPorTitulo(String titulo)
    {
        List<Libro> librosEncontrados = new ArrayList<>();
        if(titulo.length() > 4)
        {
            for (Libro l: listaLibros)
            {
                if(l.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                {
                    librosEncontrados.add(l);
                }
            }
        }
        else
        {
            System.out.println("Por favor ingrese al menos 5 caracteres");
            System.out.println("Se devuelve una lista vacía");
        }
        return librosEncontrados;
    }

}
