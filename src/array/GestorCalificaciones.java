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
   