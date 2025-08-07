public class Stand {
    private int numeroUnico;
    private String ubicacion;
    private double tamaño;
    private Empresa empresa;

    public Stand(int numeroUnico, String ubicacion, double tamaño, Empresa empresa) {
        this.numeroUnico = numeroUnico;
        this.ubicacion = ubicacion;
        this.tamaño = tamaño;
        this.empresa = empresa;
    }

    public int getNumeroUnico() { return numeroUnico; }
    public String getUbicacion() { return ubicacion; }
    public double getTamaño() { return tamaño; }
    public Empresa getEmpresa() { return empresa; }

    @Override
    public String toString() {
        return "Stand #" + numeroUnico + " - Ubicación: " + ubicacion + ", Tamaño: " + tamaño + "m2, Empresa: " + empresa.getNombre();
    }
}