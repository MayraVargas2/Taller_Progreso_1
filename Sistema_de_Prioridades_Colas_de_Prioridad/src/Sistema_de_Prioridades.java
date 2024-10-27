import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.PriorityQueue;

class Paciente {
    String nombre;
    int prioridad;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }
}

public class Sistema_de_Prioridades {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Emergencias - Prioridades");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los elementos de la interfaz
        JLabel labelNombre = new JLabel("Nombre del Paciente:");
        JTextField inputNombre = new JTextField(20);
        JLabel labelPrioridad = new JLabel("Prioridad (1 = Alta, 2 = Media, 3 = Baja):");
        JTextField inputPrioridad = new JTextField(5);
        JButton agregarButton = new JButton("Agregar Paciente");
        JButton atenderButton = new JButton("Atender Paciente");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Crear un panel para colocar los elementos
        JPanel panel = new JPanel();
        panel.add(labelNombre);
        panel.add(inputNombre);
        panel.add(labelPrioridad);
        panel.add(inputPrioridad);
        panel.add(agregarButton);
        panel.add(atenderButton);
        panel.add(new JScrollPane(outputArea));

        // Añadir el panel a la ventana principal
        frame.add(panel);
        frame.setVisible(true);

        // Cola de prioridad
        PriorityQueue<Paciente> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(p -> p.prioridad));

        // Acción para agregar paciente
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = inputNombre.getText();
                int prioridad = Integer.parseInt(inputPrioridad.getText());

                if (!nombre.isEmpty() && (prioridad == 1 || prioridad == 2 || prioridad == 3)) {
                    colaPrioridad.add(new Paciente(nombre, prioridad));
                    outputArea.append(nombre + " ha sido agregado con prioridad " + prioridad + ".\n");
                    inputNombre.setText("");
                    inputPrioridad.setText("");
                } else {
                    outputArea.append("Por favor, introduce un nombre y prioridad válidos.\n");
                }
            }
        });

        // Acción para atender paciente
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!colaPrioridad.isEmpty()) {
                    Paciente pacienteAtendido = colaPrioridad.poll();
                    outputArea.append(pacienteAtendido.nombre + " ha sido atendido (prioridad " + pacienteAtendido.prioridad + ").\n");
                } else {
                    outputArea.append("No hay más pacientes en espera.\n");
                }
            }
        });
    }
}


/*import java.util.Comparator;
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
}*/
