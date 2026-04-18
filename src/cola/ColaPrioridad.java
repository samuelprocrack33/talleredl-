// E4.3 - Cola de Prioridad: los VIP van al frente, los normales al final
public class ColaPrioridad {

    private static class Nodo {
        String cliente;
        Nodo siguiente;
        Nodo(String c) { this.cliente = c; }
    }

    private Nodo frente;
    private Nodo fin;
    private int tamanio;

    // Agrega cliente VIP al frente
    public void agregarVIP(String cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (frente == null) {
            frente = fin = nuevo;
        } else {
            nuevo.siguiente = frente;
            frente = nuevo;
        }
        tamanio++;
        System.out.println("[VIP] " + cliente + " pasó al frente.");
    }

    // Agrega cliente normal al final
    public void agregarNormal(String cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamanio++;
        System.out.println("[Normal] " + cliente + " tomó turno al final.");
    }

    // Atender al primero
    public String atender() {
        if (frente == null) { System.out.println("No hay nadie."); return null; }
        String c = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamanio--;
        return c;
    }

    public void mostrar() {
        Nodo a = frente;
        System.out.print("Cola Prioridad -> ");
        while (a != null) { System.out.print("[" + a.cliente + "] "); a = a.siguiente; }
        System.out.println();
    }
}
