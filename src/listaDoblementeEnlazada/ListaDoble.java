import java.util.Random;

public class ListaDoble {

    private NodoDoble cabeza;  // Primera canción
    private NodoDoble cola;    // Última canción
    private NodoDoble actual;  // Canción en reproducción
    private int tamanio;

    // Agregar canción al final
    public void agregarCancion(String cancion) {
        NodoDoble nuevo = new NodoDoble(cancion);
        if (cola == null) {
            cabeza = cola = actual = nuevo;
        } else {
            nuevo.anterior = cola;
            cola.siguiente = nuevo;
            cola = nuevo;
        }
        tamanio++;
    }

    // Siguiente canción – O(1)
    public String siguiente() {
        if (actual == null || actual.siguiente == null) {
            System.out.println("Ya estás en la última canción.");
            return null;
        }
        actual = actual.siguiente;
        return actual.cancion;
    }

    // Canción anterior – O(1)
    public String anterior() {
        if (actual == null || actual.anterior == null) {
            System.out.println("Ya estás en la primera canción.");
            return null;
        }
        actual = actual.anterior;
        return actual.cancion;
    }

    // Eliminar la canción actual – O(1)
    public void eliminarActual() {
        if (actual == null) return;
        NodoDoble ant = actual.anterior;
        NodoDoble sig = actual.siguiente;
        if (ant != null) ant.siguiente = sig;
        else cabeza = sig;
        if (sig != null) sig.anterior = ant;
        else cola = ant;
        actual = (sig != null) ? sig : ant;
        tamanio--;
    }

    // Mostrar de adelante hacia atrás
    public void mostrarAdelante() {
        NodoDoble temp = cabeza;
        System.out.print("Lista -> ");
        while (temp != null) {
            String marca = (temp == actual) ? "*" : "";
            System.out.print(marca + temp.cancion + marca + " <-> ");
            temp = temp.siguiente;
        }
        System.out.println("null");
    }

    // Mostrar de atrás hacia adelante
    public void mostrarAtras() {
        NodoDoble temp = cola;
        System.out.print("Inversa -> ");
        while (temp != null) {
            System.out.print(temp.cancion + " <-> ");
            temp = temp.anterior;
        }
        System.out.println("null");
    }

    // E5.1 - Inserta un nodo antes del que contiene la canción de referencia
    public void insertarAntesDe(String referencia, String nueva) {
        NodoDoble temp = cabeza;
        while (temp != null) {
            if (temp.cancion.equals(referencia)) {
                NodoDoble nuevo = new NodoDoble(nueva);
                nuevo.siguiente = temp;
                nuevo.anterior = temp.anterior;
                if (temp.anterior != null) temp.anterior.siguiente = nuevo;
                else cabeza = nuevo; // era el primero
                temp.anterior = nuevo;
                tamanio++;
                return;
            }
            temp = temp.siguiente;
        }
        System.out.println("Referencia no encontrada.");
    }

    // E5.2 - Mueve la canción actual al inicio
    public void moverAlInicio() {
        if (actual == null || actual == cabeza) return;
        eliminarActual();
        NodoDoble nuevo = new NodoDoble(actual != null ? actual.cancion : "");
        // re-insertar al inicio
        NodoDoble temp = new NodoDoble(nuevo.cancion);
        temp.siguiente = cabeza;
        if (cabeza != null) cabeza.anterior = temp;
        else cola = temp;
        cabeza = temp;
        actual = temp;
        tamanio++;
    }

    // E5.3 - Retorna una canción en posición aleatoria
    public String modoAleatorio() {
        if (tamanio == 0) return null;
        int pos = new Random().nextInt(tamanio);
        NodoDoble temp = cabeza;
        for (int i = 0; i < pos; i++) temp = temp.siguiente;
        actual = temp;
        return temp.cancion;
    }

    // E5.4 - Invierte el orden de todas las canciones
    public void invertirLista() {
        NodoDoble temp = cabeza;
        NodoDoble aux = null;
        while (temp != null) {
            aux = temp.anterior;
            temp.anterior = temp.siguiente;
            temp.siguiente = aux;
            temp = temp.anterior; // avanzar (era siguiente)
        }
        if (aux != null) {
            cola = cabeza;
            cabeza = aux.anterior;
        }
    }

    public String getActual() { return actual != null ? actual.cancion : "ninguna"; }
}
