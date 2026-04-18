public class ListaEnlazada {

    private Nodo cabeza;
    private int tamanio;

    public ListaEnlazada() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Insertar al inicio – O(1)
    public void insertarAlInicio(String dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cabeza;
        cabeza = nuevo;
        tamanio++;
    }

    // Insertar al final – O(n)
    public void insertarAlFinal(String dato) {
        Nodo nuevo = new Nodo(dato);
        if (cabeza == null) { cabeza = nuevo; tamanio++; return; }
        Nodo actual = cabeza;
        while (actual.siguiente != null)
            actual = actual.siguiente;
        actual.siguiente = nuevo;
        tamanio++;
    }

    // Eliminar al inicio – O(1)
    public String eliminarAlInicio() {
        if (cabeza == null) return null;
        String dato = cabeza.dato;
        cabeza = cabeza.siguiente;
        tamanio--;
        return dato;
    }

    // Buscar un elemento – O(n)
    public boolean buscar(String dato) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) return true;
            actual = actual.siguiente;
        }
        return false;
    }

    // Mostrar todos los elementos
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    // E2.1 - Retorna cuántos elementos tiene la lista
    public int tamanio() {
        return tamanio;
    }

    // E2.2 - Retorna el elemento en la posición i
    public String obtenerPorIndice(int i) {
        if (i < 0 || i >= tamanio) return null;
        Nodo actual = cabeza;
        for (int j = 0; j < i; j++)
            actual = actual.siguiente;
        return actual.dato;
    }

    // E2.3 - Elimina el primer nodo que tenga ese valor
    public boolean eliminarPorValor(String dato) {
        if (cabeza == null) return false;
        if (cabeza.dato.equals(dato)) {
            cabeza = cabeza.siguiente;
            tamanio--;
            return true;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null) {
            if (actual.siguiente.dato.equals(dato)) {
                actual.siguiente = actual.siguiente.siguiente;
                tamanio--;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    // E2.4 - Invierte el orden de la lista sin estructuras auxiliares
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }
        cabeza = anterior;
    }

    // E2.6 - Detecta si hay un ciclo usando el algoritmo de Floyd (tortuga y liebre)
    public boolean detectarCiclo() {
        Nodo lento = cabeza; // tortuga
        Nodo rapido = cabeza; // liebre
        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;
            if (lento == rapido) return true; // se encontraron: hay ciclo
        }
        return false;
    }
}
