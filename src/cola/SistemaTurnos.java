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
 public String peek()     { return isEmpty() ? null : frente.cliente; }
    public boolean isEmpty() { return frente == null; }
    public int tamanio()     { return tamanio; }

    public void mostrarFila() {
        Nodo actual = frente;
        System.out.print("Fila -> ");
        while (actual != null) {
            System.out.print("[" + actual.cliente + "] ");
            actual = actual.siguiente;
        }
        System.out.println();
    }

    // E4.1 - Retorna la posición del cliente en la fila (1 = primero)
    public int posicion(String cliente) {
        Nodo actual = frente;
        int pos = 1;
        while (actual != null) {
            if (actual.cliente.equals(cliente)) return pos;
            actual = actual.siguiente;
            pos++;
        }
        return -1; // no está en la fila
    }

    // E4.2 - Mueve al primer cliente al final de la fila (castigo)
    public void saltarTurno() {
        if (isEmpty() || frente == fin) return; // no hay a quién mover
        String primero = dequeue();
        // enqueue sin imprimir el mensaje del turn
        Nodo nuevo = new Nodo(primero);
        fin.siguiente = nuevo;
        fin = nuevo;
        tamanio++;
        System.out.println(primero + " fue movido al final (turno perdido).");
    }
}
  