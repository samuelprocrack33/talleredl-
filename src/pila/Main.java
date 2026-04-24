// E3.5 - Simula el historial de páginas de un navegador
public class Main {
    public static void main(String[] args) {

        Pila navegador = new Pila(20);

        // Visitar páginas
        navegador.push("google.com");
        navegador.push("youtube.com");
        navegador.push("github.com");
        navegador.push("stackoverflow.com");
        navegador.push("moodle.remington.edu.co");
        navegador.push("docs.oracle.com/java");

        System.out.println("Historial del navegador:");
        navegador.mostrar();

        System.out.println("Página actual: " + navegador.peek());

        // Clic en 'Atrás'
        System.out.println("\nVolviendo atrás...");
        System.out.println("Saliendo de: " + navegador.pop());
        System.out.println("Saliendo de: " + navegador.pop());

        System.out.println("Página actual ahora: " + navegador.peek());
        navegador.mostrar();

        // Verificar balanceo de expresiones
        System.out.println("\n--- Balanceo de expresiones ---");
        System.out.println("({[]}) -> " + Pila.verificarBalanceo("({[]})"));
        System.out.println("([)]  -> " + Pila.verificarBalanceo("([)]"));
        System.out.println("{[()]} -> " + Pila.verificarBalanceo("{[()]}"));

        // Invertir cadena
        System.out.println("\n--- Invertir cadena ---");
        System.out.println("Yopal -> " + Pila.invertirCadena("Yopal"));

        // Notación postfija
        System.out.println("\n--- Notación postfija ---");
        System.out.println("3 4 + 2 * = " + Pila.evaluarPostfija("3 4 + 2 *")); // 14
        System.out.println("5 1 2 + 4 * + 3 - = " + Pila.evaluarPostfija("5 1 2 + 4 * + 3 -")); // 14
    }
}
