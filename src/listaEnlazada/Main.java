// E2.5 - Simula el historial de canciones de Spotify Yopal
public class Main {
    public static void main(String[] args) {

        ListaEnlazada historial = new ListaEnlazada();

        // Agregar 5 canciones al historial
        historial.insertarAlFinal("El Gavilan – Reynaldo Armas");
        historial.insertarAlFinal("Caballo Viejo – Simón Díaz");
        historial.insertarAlFinal("Fiesta en Elorza – Ángel Custodio");
        historial.insertarAlFinal("Concierto en la Llanura – Arnulfo Briceño");
        historial.insertarAlFinal("Bonito que es el Llano – Los Llaneros");

        System.out.println("Historial inicial:");
        historial.mostrar();

        // Eliminar la primera canción reproducida
        String eliminada = historial.eliminarAlInicio();
        System.out.println("\nEliminada: " + eliminada);

        // Buscar una canción específica
        String buscar = "Caballo Viejo – Simón Díaz";
        System.out.println("¿Está '" + buscar + "'? " + historial.buscar(buscar));

        System.out.println("\nHistorial actualizado:");
        historial.mostrar();

        System.out.println("Tamaño: " + historial.tamanio());
        System.out.println("Canción en índice 1: " + historial.obtenerPorIndice(1));

        // Eliminar por valor
        historial.eliminarPorValor("Concierto en la Llanura – Arnulfo Briceño");
        System.out.println("\nDespués de eliminar por valor:");
        historial.mostrar();

        // Invertir la lista
        historial.invertir();
        System.out.println("Lista invertida:");
        historial.mostrar();

        // Detectar ciclo (en este caso no hay)
        System.out.println("¿Hay ciclo? " + historial.detectarCiclo());
    }
}
