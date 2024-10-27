import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class Gestion_de_una_fila {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame frame = new JFrame("Gestión de Fila en el Banco");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear los elementos de la interfaz
        JLabel label = new JLabel("Introduce el nombre del cliente:");
        JTextField inputField = new JTextField(20);
        JButton agregarButton = new JButton("Agregar a la Fila");
        JButton atenderButton = new JButton("Atender Cliente");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Crear un panel para colocar los elementos
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(inputField);
        panel.add(agregarButton);
        panel.add(atenderButton);
        panel.add(new JScrollPane(outputArea));

        // Añadir el panel a la ventana principal
        frame.add(panel);
        frame.setVisible(true);

        // Cola de clientes
        Queue<String> cola = new LinkedList<>();

        // Acción para agregar cliente a la fila
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cliente = inputField.getText();
                if (!cliente.isEmpty()) {
                    cola.add(cliente);
                    outputArea.append(cliente + " ha sido agregado a la fila.\n");
                    inputField.setText("");
                } else {
                    outputArea.append("Por favor, introduce un nombre válido.\n");
                }
            }
        });

        // Acción para atender cliente
        atenderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cola.isEmpty()) {
                    String clienteAtendido = cola.poll();
                    outputArea.append(clienteAtendido + " ha sido atendido/a.\n");
                } else {
                    outputArea.append("No hay más clientes en la fila.\n");
                }
            }
        });
    }
}



/*import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;


public class Gestion_de_una_fila {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue<String> fila = new LinkedList<String>();
		
		System.out.println("Ingrese el numero de clientes");
		int num = scan.nextInt();
		scan.nextLine();
		 
		System.out.println("\nIngrese los nombres de los clientes");
		for (int i = 0; i < num; i++) {
			fila.add(scan.nextLine());
		}
		
		System.out.println();
		while(!fila.isEmpty()) {
			System.out.println(fila.poll() + " ha sido atendido/a");
		}	
	}
}
*/