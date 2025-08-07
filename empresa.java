// Empresa.java
public class Empresa {
    private String nombre;
    private String sector;
    private String correoElectronico; // Usado como identificador único

    // Constructor, getters y setters...
    // ...
}

// Stand.java
public class Stand {
    private int numeroUnico;
    private String ubicacion;
    private String tamano;
    private Empresa empresaAsignada;
    private List<Comentario> comentarios;

    // Constructor, getters, setters y agregarComentario()...
    // ...
}

// Visitante.java
public class Visitante {
    private String nombre;
    private String identificacion; // Usado como identificador único
    private String correoElectronico;

    // Constructor, getters y setters...
    // ...
}

// Comentario.java
import java.time.LocalDate;

public class Comentario {
    private Visitante autor;
    private LocalDate fecha;
    private int calificacion;
    private String texto;

    // Constructor, getters y setters...
    // ...
}