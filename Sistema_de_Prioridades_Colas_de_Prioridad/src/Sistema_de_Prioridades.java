import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Paciente {
    String nombre;
    int prioridad;

    public Paciente(String nombrei, int prioridadi) {
        nombre = nombrei;
        prioridad = prioridadi;
    }
}

public class Sistema_de_Prioridades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PriorityQueue<Paciente> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(p -> p.prioridad));

        System.out.println("Introduce la cantidad de pacientes:");
        int cantidad = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Introduce el nombre del paciente y su prioridad (1 = alta, 2 = media, 3 = baja):");
            String[] entrada = scan.nextLine().split(" ");
            String nombre = entrada[0];
            int prioridad = Integer.parseInt(entrada[1]);
            colaPrioridad.add(new Paciente(nombre, prioridad));
        }

        while (!colaPrioridad.isEmpty()) {
            Paciente paciente = colaPrioridad.poll();
            System.out.println(paciente.nombre + " ha sido atendido (prioridad " + paciente.prioridad + ").");
        }
    }
}
