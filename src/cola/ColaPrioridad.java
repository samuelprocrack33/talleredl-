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
    
  