import java.time.LocalDate;

public class Comentario {
    private Visitante visitante;
    private LocalDate fecha;
    private int calificacion; // 1-5
    private String comentario;

    public Comentario(Visitante visitante, LocalDate fecha, int calificacion, String comentario) {
        this.visitante = visitante;
        this.fecha = fecha;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Visitante getVisitante() { return visitante; }
    public LocalDate getFecha() { return fecha; }
    public int getCalificacion() { return calificacion; }
    public String getComentario() { return comentario; }

    @Override
    public String toString() {
        return "Comentario de " + visitante.getNombre() + " [" + fecha + "]: " +
                "Calificación: " + calificacion + ", \"" + comentario + "\"";
    }
}