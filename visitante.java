public class Visitante {
    private String nombre;
    private String identificacion;
    private String correoElectronico;

    public Visitante(String nombre, String identificacion, String correoElectronico) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getCorreoElectronico() { return correoElectronico; }

    @Override
    public String toString() {
        return "Visitante: " + nombre + " (" + identificacion + "), Email: " + correoElectronico;
    }
}