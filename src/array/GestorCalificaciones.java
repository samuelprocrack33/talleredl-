public class GestorCalificaciones {

    private double[] calificaciones;
    private int totalEstudiantes;

    // Constructor: define el tamaño máximo al crear el objeto
    public GestorCalificaciones(int capacidad) {
        this.calificaciones = new double[capacidad];
        this.totalEstudiantes = 0;
    }

    // Agregar calificación si hay espacio
    public boolean agregar(double nota) {
        if (totalEstudiantes >= calificaciones.length) {
            System.out.println("No hay más espacio en el array.");
            return false;
        }
        calificaciones[totalEstudiantes] = nota;
        totalEstudiantes++;
        return true;
    }

    // Acceso directo por índice – O(1)
    public double obtener(int indice) {
        if (indice < 0 || indice >= totalEstudiantes)
            throw new IndexOutOfBoundsException("Índice inválido");
        return calificaciones[indice];
    }

    // Calcular promedio
    public double promedio() {
        if (totalEstudiantes == 0) return 0;
        double suma = 0;
        for (int i = 0; i < totalEstudiantes; i++)
            suma += calificaciones[i];
        return suma / totalEstudiantes;
    }

    public double mayor() {
        if (totalEstudiantes == 0) return 0;
        double max = calificaciones[0];
        for (int i = 1; i < totalEstudiantes; i++)
            if (calificaciones[i] > max) max = calificaciones[i];
        return max;
    }

    // E1.1
    public double menor() {
        if (totalEstudiantes == 0) return 0;
        double min = calificaciones[0];
        for (int i = 1; i < totalEstudiantes; i++)
            if (calificaciones[i] < min) min = calificaciones[i];
        return min;
    }

    // E1.2
    public int buscarNota(double nota) {
        for (int i = 0; i < totalEstudiantes; i++)
            if (calificaciones[i] == nota) return i;
        return -1;
    }

    // E1.3
    public void ordenarBurbuja() {
        for (int i = 0; i < totalEstudiantes - 1; i++)
            for (int j = 0; j < totalEstudiantes - i - 1; j++)
                if (calificaciones[j] > calificaciones[j + 1]) {
                    double temp = calificaciones[j];
                    calificaciones[j] = calificaciones[j + 1];
                    calificaciones[j + 1] = temp;
                }
    }

    // E1.4
    public int contarAprobados(double minAprobatoria) {
        int conteo = 0;
        for (int i = 0; i < totalEstudiantes; i++)
            if (calificaciones[i] >= minAprobatoria) conteo++;
        return conteo;
    }

    // E1.6
    public static double[] union(double[] a, double[] b) {
        double[] temp = new double[a.length + b.length];
        int cont = 0;
        for (double v : a) {
            boolean existe = false;
            for (int i = 0; i < cont; i++) if (temp[i] == v) { existe = true; break; }
            if (!existe) temp[cont++] = v;
        }
        for (double v : b) {
            boolean existe = false;
            for (int i = 0; i < cont; i++) if (temp[i] == v) { existe = true; break; }
            if (!existe) temp[cont++] = v;
        }
        double[] resultado = new double[cont];
        System.arraycopy(temp, 0, resultado, 0, cont);
        return resultado;
    }

    public void mostrar() {
        System.out.print("Calificaciones: ");
        for (int i = 0; i < totalEstudiantes; i++)
            System.out.print(calificaciones[i] + (i < totalEstudiantes - 1 ? ", " : ""));
        System.out.println();
    }
}