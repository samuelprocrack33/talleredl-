// E5.5 - Reproductor con canciones llaneras
public class Main {
    public static void main(String[] args) {

        ListaDoble reproductor = new ListaDoble();

        // 7 canciones llaneras
        reproductor.agregarCancion("Alma Llanera – Pedro Elías Gutiérrez");
        reproductor.agregarCancion("El Gavilán – Reynaldo Armas");
        reproductor.agregarCancion("Fiesta en Elorza – Ángel Custodio");
        reproductor.agregarCancion("Caballo Viejo – Simón Díaz");
        reproductor.agregarCancion("Bello Horizonte – Juan Farfán");
        reproductor.agregarCancion("Cimarrón – Orlando Valderrama");
        reproductor.agregarCancion("Pajarillo – Tradicional Llanero");

        System.out.println("Playlist inicial:");
        reproductor.mostrarAdelante();
        System.out.println("Reproduciendo: " + reproductor.getActual());

        // Navegar adelante 3 veces
        System.out.println("\nAvanzando 3 veces...");
        for (int i = 0; i < 3; i++)
            System.out.println("  -> " + reproductor.siguiente());

        // Retroceder 1 vez
        System.out.println("\nRetrocediendo 1 vez...");
        System.out.println("  <- " + reproductor.anterior());

        System.out.println("Reproduciendo ahora: " + reproductor.getActual());

        // Eliminar la canción actual
        System.out.println("\nEliminando canción actual...");
        reproductor.eliminarActual();

        // Mostrar en ambas direcciones
        System.out.println("\nPlaylist adelante:");
        reproductor.mostrarAdelante();
        System.out.println("Playlist atrás:");
        reproductor.mostrarAtras();

        // Canción aleatoria
        System.out.println("\nModo aleatorio: " + reproductor.modoAleatorio());

        // Insertar antes de una referencia
        reproductor.insertarAntesDe("Pajarillo – Tradicional Llanero", "Los Torrealberos – Venezuela");
        System.out.println("\nTras insertar antes de Pajarillo:");
        reproductor.mostrarAdelante();
    }
}
