import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FeriaEmpresarial {
    private List<Empresa> empresas = new ArrayList<>();
    private List<Stand> stands = new ArrayList<>();
    private List<Visitante> visitantes = new ArrayList<>();

    // --- Métodos de REGISTRO ---
    public void registrarEmpresa(Empresa empresa) { /* ... */ }
    public void registrarStand(Stand stand) { /* ... */ }
    public void registrarVisitante(Visitante visitante) { /* ... */ }

    // --- Métodos de EDICIÓN ---
    public boolean editarEmpresa(String correo, String nuevoNombre, String nuevoSector) {
        for (Empresa e : empresas) {
            if (e.getCorreoElectronico().equalsIgnoreCase(correo)) {
                e.setNombre(nuevoNombre);
                e.setSector(nuevoSector);
                System.out.println("✅ Empresa actualizada.");
                return true;
            }
        }
        System.out.println("❌ Empresa no encontrada.");
        return false;
    }

    public boolean editarVisitante(String id, String nuevoNombre, String nuevoCorreo) {
        Optional<Visitante> visitante = visitantes.stream().filter(v -> v.getIdentificacion().equals(id)).findFirst();
        if (visitante.isPresent()) {
            visitante.get().setNombre(nuevoNombre);
            visitante.get().setCorreoElectronico(nuevoCorreo);
            System.out.println("✅ Visitante actualizado.");
            return true;
        }
        System.out.println("❌ Visitante no encontrado.");
        return false;
    }

    // --- Métodos de ELIMINACIÓN ---
    public boolean eliminarEmpresa(String correo) {
        boolean removed = empresas.removeIf(e -> e.getCorreoElectronico().equalsIgnoreCase(correo));
        if(removed) System.out.println("✅ Empresa eliminada.");
        else System.out.println("❌ Empresa no encontrada.");
        return removed;
    }
    
    public boolean eliminarVisitante(String id) {
        boolean removed = visitantes.removeIf(v -> v.getIdentificacion().equals(id));
        if(removed) System.out.println("✅ Visitante eliminado.");
        else System.out.println("❌ Visitante no encontrado.");
        return removed;
    }

    // --- Métodos de ASIGNACIÓN E INTERACCIÓN ---
    public void asignarStandAEmpresa(int idStand, String correoEmpresa) { /* ... */ }
    public void agregarComentarioAStand(int idStand, Comentario comentario) { /* ... */ }

    // --- Métodos de REPORTES ESPECÍFICOS ---
    public void generarReporteEmpresasConStand() {
        System.out.println("\n---  रिपोर्ट: Empresas y Stands Asignados ---");
        empresas.forEach(System.out::println);
    }
    
    public void generarReporteVisitantes() {
        System.out.println("\n--- 👥 Reporte: Visitantes Registrados ---");
        visitantes.forEach(System.out::println);
    }

    public void generarReporteCalificaciones() {
        System.out.println("\n--- ⭐ Reporte: Calificación Promedio por Stand ---");
        for (Stand stand : stands) {
            if (stand.getEmpresaAsignada() != null) {
                double promedio = stand.getComentarios().stream()
                                      .mapToDouble(Comentario::getCalificacion)
                                      .average()
                                      .orElse(0.0); // Devuelve 0.0 si no hay comentarios
                System.out.printf("Stand N°%d (%s): Calificación Promedio: %.2f / 5.0\n",
                        stand.getNumeroUnico(), stand.getEmpresaAsignada().getNombre(), promedio);
            }
        }
    }

    public void listarStandsOcupados() {
        System.out.println("\n--- 🛑 Reporte: Stands Ocupados ---");
        stands.stream()
              .filter(s -> s.getEmpresaAsignada() != null)
              .forEach(System.out::println);
    }
    
    public void listarStandsDisponibles() {
        System.out.println("\n--- ✅ Reporte: Stands Disponibles ---");
        stands.stream()
              .filter(s -> s.getEmpresaAsignada() == null)
              .forEach(System.out::println);
    }
}