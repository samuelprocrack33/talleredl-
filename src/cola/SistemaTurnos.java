public class SistemaTurnos {

    // Nodo interno de la cola
    private static class Nodo {
        String cliente;
        Nodo siguiente;
        Nodo(String c) { this.cliente = c; }
    }

    private Nodo frente; // Primer cliente en la fila
    private Nodo fin;    // Último cliente en la fila
    private int tamanio;

    // enqueue – Llega un nuevo cliente al final – O(1)
    public void enqueue(String cliente) {
        Nodo nuevo = new Nodo(cliente);
        if (fin == null) {
            frente = fin = nuevo;
        } else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
        tamanio++;
        System.out.println(cliente + " tomó turno. Posición: " + tamanio);
    }

    // dequeue – Atender al primer cliente – O(1)
    public String dequeue() {
        if (isEmpty()) {
            System.out.println("No hay clientes en espera.");
            return null;
        }
        String cliente = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) fin = null;
        tamanio--;
        System.out.println("Atendiendo a: " + cliente);
        return cliente;
    }

    