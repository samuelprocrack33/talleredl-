public class Pila {

    private String[] elementos;
    private int tope;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = new String[capacidad];
        this.tope = -1; // -1 significa pila vacía
    }

    // push – Agregar en el tope – O(1)
    public boolean push(String elemento) {
        if (tope == capacidad - 1) {
            System.out.println("Pila llena (Stack Overflow)");
            return false;
        }
        tope++;
        elementos[tope] = elemento;
        System.out.println(elemento + " apilado.");
        return true;
    }

    // pop – Quitar el tope – O(1)
    public String pop() {
        if (isEmpty()) {
            System.out.println("Pila vacía (Stack Underflow)");
            return null;
        }
        String elemento = elementos[tope];
        elementos[tope] = null;
        tope--;
        return elemento;
    }

    // peek – Ver el tope sin quitar – O(1)
    public String peek() {
        if (isEmpty()) return null;
        return elementos[tope];
    }

    public boolean isEmpty() { return tope == -1; }
    public int tamanio()     { return tope + 1; }

    // E3.1 - Muestra todos los elementos del tope a la base sin vaciar la pila
    public void mostrar() {
        if (isEmpty()) { System.out.println("Pila vacía"); return; }
        System.out.print("Pila (tope -> base): ");
        for (int i = tope; i >= 0; i--)
            System.out.print(elementos[i] + (i > 0 ? " | " : ""));
        System.out.println();
    }

    // E3.2 - Verifica si los paréntesis, corchetes y llaves están balanceados
    public static boolean verificarBalanceo(String expresion) {
        Pila pila = new Pila(expresion.length());
        for (char c : expresion.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                pila.push(String.valueOf(c));
            } else if (c == ')' || c == ']' || c == '}') {
                if (pila.isEmpty()) return false;
                String tope = pila.pop();
                if (c == ')' && !tope.equals("(")) return false;
                if (c == ']' && !tope.equals("[")) return false;
                if (c == '}' && !tope.equals("{")) return false;
            }
        }
        return pila.isEmpty(); // si quedó vacía, todo estaba balanceado
    }

    // E3.3 - Invierte una cadena usando la pila
    public static String invertirCadena(String texto) {
        Pila pila = new Pila(texto.length());
        for (char c : texto.toCharArray())
            pila.push(String.valueOf(c));
        StringBuilder resultado = new StringBuilder();
        while (!pila.isEmpty())
            resultado.append(pila.pop());
        return resultado.toString();
    }

    // E3.4 - Evalúa expresiones en notación postfija (Ej: "3 4 + 2 *" = 14)
    public static int evaluarPostfija(String expresion) {
        Pila pila = new Pila(20);
        String[] tokens = expresion.split(" ");
        for (String token : tokens) {
            if (token.matches("-?\\d+")) {
                pila.push(token); // es un número
            } else {
                int b = Integer.parseInt(pila.pop());
                int a = Integer.parseInt(pila.pop());
                int resultado = switch (token) {
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default  -> 0;
                };
                pila.push(String.valueOf(resultado));
            }
        }
        return Integer.parseInt(pila.pop());
    }
}
