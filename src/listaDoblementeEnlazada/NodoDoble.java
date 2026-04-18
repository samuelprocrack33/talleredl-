// Nodo con dos ganchos: apunta al anterior y al siguiente
public class NodoDoble {
    String cancion;
    NodoDoble anterior;
    NodoDoble siguiente;

    public NodoDoble(String cancion) {
        this.cancion = cancion;
        this.anterior = null;
        this.siguiente = null;
    }
}
