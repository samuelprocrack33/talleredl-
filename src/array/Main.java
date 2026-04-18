// E1.5 - Clase principal para probar GestorCalificaciones
public class Main {
    public static void main(String[] args) {

        GestorCalificaciones gestor = new GestorCalificaciones(10);

        // Registrar 10 calificaciones de estudiantes de TechStore Yopal
        double[] notas = {4.5, 2.8, 3.9, 1.5, 4.0, 3.2, 2.5, 4.8, 3.0, 2.2};
        for (double nota : notas)
            gestor.agregar(nota);

        gestor.mostrar();
        System.out.println("Promedio: " + gestor.promedio());
        System.out.println("Mayor nota: " + gestor.mayor());
        System.out.println("Menor nota: " + gestor.menor());
        System.out.println("Aprobados (>= 3.0): " + gestor.contarAprobados(3.0));

        // Buscar una nota
        System.out.println("Índice de nota 4.0: " + gestor.buscarNota(4.0));

        // Ordenar y mostrar
        gestor.ordenarBurbuja();
        System.out.print("Ordenadas: ");
        gestor.mostrar();

        // E1.6 - Unión de dos arrays
        double[] a = {1.0, 2.0, 3.0};
        double[] b = {2.0, 3.0, 4.0, 5.0};
        double[] union = GestorCalificaciones.union(a, b);
        System.out.print("Unión sin duplicados: ");
        for (double v : union) System.out.print(v + " ");
        System.out.println();
    }
}
