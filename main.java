public class Main {
    public static void main(String[] args) {
        FeriaEmpresarial feria = new FeriaEmpresarial();
        System.out.println("🚀 Iniciando simulación de Feria Empresarial...\n");

        // 1. Registrar entidades
        feria.registrarEmpresa(new Empresa("Innovatech", "Tecnología", "contacto@innovatech.com"));
        feria.registrarEmpresa(new Empresa("Sabor Local", "Alimentos", "ventas@saborlocal.co"));
        feria.registrarVisitante(new Visitante("Ana Gómez", "12345", "ana.gomez@email.com"));
        
        // 2. Probar EDICIÓN
        System.out.println("\n--- Probando Edición ---");
        feria.editarEmpresa("contacto@innovatech.com", "Innovatech Global", "Tech y Software");
        
        // 3. Probar ELIMINACIÓN
        System.out.println("\n--- Probando Eliminación ---");
        feria.registrarVisitante(new Visitante("Carlos Ruiz", "67890", "c.ruiz@email.com"));
        feria.eliminarVisitante("67890"); // Eliminar a Carlos

        // 4. Asignar Stands y dejar comentarios...
        Stand stand101 = new Stand(101, "Pabellón A", "3x3m");
        feria.registrarStand(stand101);
        feria.asignarStandAEmpresa(101, "contacto@innovatech.com");
        feria.agregarComentarioAStand(101, new Comentario(feria.buscarVisitante("12345"), 5, "¡Genial!"));
        feria.agregarComentarioAStand(101, new Comentario(feria.buscarVisitante("12345"), 4, "Buenos productos."));

        // 5. GENERAR TODOS LOS REPORTES CORREGIDOS
        feria.generarReporteEmpresasConStand();
        feria.listarStandsOcupados();
        feria.listarStandsDisponibles();
        feria.generarReporteVisitantes();
        feria.generarReporteCalificaciones();
    }
}