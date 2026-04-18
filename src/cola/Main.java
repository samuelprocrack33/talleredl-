// E4.4 - Simula el sistema de turnos del Banco Agrario Yopal
public class Main {
    public static void main(String[] args) {

        SistemaTurnos banco = new SistemaTurnos();

        // 8 clientes llegan
        String[] clientes = {"Ana", "Luis", "Marta", "Pedro", "Sofía", "Carlos", "Diana", "Jorge"};
        for (String c : clientes)
            banco.enqueue(c);

        System.out.println("\nFila inicial:");
        banco.mostrarFila();

        System.out.println("Posición de Pedro: " + banco.posicion("Pedro"));

        // Se atienden de 2 en 2 cada ronda
        int ronda = 1;
        while (!banco.isEmpty()) {
            System.out.println("\n--- Ronda " + ronda + " ---");
            for (int i = 0; i < 2 && !banco.isEmpty(); i++)
                banco.dequeue();
            banco.mostrarFila();
            ronda++;
        }

        // Probar saltarTurno
        System.out.println("\n--- Prueba saltarTurno ---");
        SistemaTurnos prueba = new SistemaTurnos();
        prueba.enqueue("Primero");
        prueba.enqueue("Segundo");
        prueba.enqueue("Tercero");
        prueba.mostrarFila();
        prueba.saltarTurno();
        prueba.mostrarFila();

        // E4.3 - Cola Prioridad
        System.out.println("\n--- Cola con Prioridad ---");
        ColaPrioridad cp = new ColaPrioridad();
        cp.agregarNormal("Cliente1");
        cp.agregarNormal("Cliente2");
        cp.agregarVIP("VIP-Juan");
        cp.agregarNormal("Cliente3");
        cp.agregarVIP("VIP-María");
        cp.mostrar();
        System.out.println("Atendiendo: " + cp.atender());
        cp.mostrar();
    }
}
